package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.repository.CredentialQuery;
import com.qinghaotech.domain.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


/**
 * @author Jinx
 */
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {
    public static final String ACCESS_TOKEN_PARAMETER = "Authorization";
    public static final Collection<String> PERMIT_PATTERNS = Arrays.asList(
            "/login",
            "/test/**"
    );

    private final UserRepository userRepository;
    private final AntPathMatcher matcher;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        if (isPermissible(request)) {
            filterChain.doFilter(request, response);
        } else {
            String accessToken = request.getHeader(ACCESS_TOKEN_PARAMETER);
            if (StringUtils.hasText(accessToken)) {
                CredentialQuery query = CredentialQuery.builder()
                        .accessToken(accessToken)
                        .build();
                var user = userRepository.findByCredential(query);
                if (user.isEmpty()) {
                    throw new InvalidBearerTokenException("Invalid access token : %s".formatted(accessToken));
                }

                Credential credential = user.get().getCredential();
                if (credential == null) {
                    throw new InvalidBearerTokenException("Invalid access token : %s".formatted(accessToken));
                }
                if (credential.isAccessTokenExpired()) {
                    throw new AccountExpiredException("Access token has expired");
                }

                UserDetail userDetail = new UserDetail(user.get());
                Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                        userDetail, credential, Collections.emptyList()
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);

                filterChain.doFilter(request, response);
                return;
            }

            throw new AuthenticationCredentialsNotFoundException("AccessToken not found");
        }
    }

    /**
     * 是否允许的url
     *
     * @param request 请求信息
     * @return true：允许的
     */
    private boolean isPermissible(@NonNull HttpServletRequest request) {
        String path = request.getRequestURI();
        return PERMIT_PATTERNS.stream().noneMatch(url -> matcher.match(url, path));
    }
}
