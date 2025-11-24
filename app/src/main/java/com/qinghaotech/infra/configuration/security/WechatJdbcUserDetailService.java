package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.AppConfiguration;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.primitive.Applet;
import com.qinghaotech.domain.repository.AppletQuery;
import com.qinghaotech.domain.repository.UserRepository;
import com.qinghaotech.vendor.WechatClient;
import com.qinghaotech.vendor.WechatLoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * 扩展 {@link UsernamePasswordAuthenticationFilter}，username 为微信 js_code
 *
 * @author jinx
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WechatJdbcUserDetailService implements UserDetailsService {

    private final UserRepository userRepo;
    private final WechatClient client;
    private final AppConfiguration configuration;
    private final EntityFactory<User> factory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.hasText(username, "Wechat js_code is empty!");

        var wechatApplet = configuration.getWechatApplet();
        var request = WechatLoginRequest.builder()
                .appId(wechatApplet.getAppId())
                .appSecret(wechatApplet.getAppSecret())
                .loginCode(username)
                .build();
        var response = client.login(request);
        if (!response.isSuccess()) {
            throw new AuthenticationServiceException("Fail to Request Wechat : %s".formatted(response.getErrMsg()));
        }

        AppletQuery query = AppletQuery.builder()
                .openId(response.getOpenId())
                .unionId(response.getUnionId())
                .build();
        Optional<User> user = userRepo.findByApplet(query);
        if (user.isEmpty()) {
            // 小程序用户 第一次登录进行注册
            Applet applet = new Applet(response.getOpenId(), response.getUnionId());
            user = Optional.of(factory.create(applet));
            userRepo.save(user.get());
        }

        return new UserDetail(user.get());
    }
}
