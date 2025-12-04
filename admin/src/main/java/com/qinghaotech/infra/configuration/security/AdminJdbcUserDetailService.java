package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.application.support.UserDetail;
import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 扩展 {@link UsernamePasswordAuthenticationFilter}，username 为微信 js_code
 *
 * @author jinx
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AdminJdbcUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("username {%s} not found".formatted(username));
        }

        return new UserDetail(user.get());
    }
}
