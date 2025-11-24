package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.application.converter.CredentialConverter;
import com.qinghaotech.domain.repository.UserRepository;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.util.AntPathMatcher;

/**
 * @author jinx
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AntPathMatcher matcher = new AntPathMatcher();

    private final WechatJdbcUserDetailService userDetailService;
    private final UserRepository userRepository;
    private final CredentialConverter credentialConverter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // 永远返回true
                return true;
            }
        };
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        var authenticationPostHandler = new AuthenticationPostHandler(userRepository, credentialConverter);
        Filter exceptionHandlerFilter = new ExceptionHandlerFilter();
        Filter tokenRefreshFilter = new TokenRefreshFilter(userRepository, credentialConverter, matcher);
        Filter tokenFilter = new TokenFilter(userRepository, matcher);

        return http
                .csrf(CsrfConfigurer::disable)
                .cors(CorsConfigurer::disable)
                .formLogin(configurer -> configurer
                        .successHandler(authenticationPostHandler)
                        .failureHandler(authenticationPostHandler)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .userDetailsService(userDetailService)
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(tokenRefreshFilter, TokenFilter.class)
                .addFilterBefore(exceptionHandlerFilter, SecurityContextHolderFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(
                "/docs/**",
                "/ping",
                "/error"
        );
    }
}
