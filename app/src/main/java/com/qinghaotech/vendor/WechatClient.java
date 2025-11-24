package com.qinghaotech.vendor;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * @author Jinx
 */
public interface WechatClient {

    default WechatLoginResponse login(WechatLoginRequest request) {
        return login(
                request.getAppId(),
                request.getAppSecret(),
                request.getLoginCode(),
                request.getGrantType()
        );
    }

    @GetExchange("/sns/jscode2session")
    WechatLoginResponse login(@RequestParam("appid") String appId,
                              @RequestParam("secret") String secret,
                              @RequestParam("js_code") String jsCode,
                              @RequestParam("grant_type") String grantType);

}
