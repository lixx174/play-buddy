package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.converter.CredentialConverter;
import com.qinghaotech.application.model.dto.CredentialDto;
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
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.qinghaotech.infra.configuration.support.ManualResponseSupport.doJsonResponse;


/**
 * @author Jinx
 */
@RequiredArgsConstructor
public class TokenRefreshFilter extends OncePerRequestFilter {
    public static final String REFRESH_TOKEN_PARAMETER = "refreshToken";
    public static final String PATTERN = "/token/refresh";

    private final UserRepository userRepository;
    private final CredentialConverter credentialConverter;
    private final AntPathMatcher matcher;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (isAvailableUrl(request)) {
            String refreshToken = request.getParameter(REFRESH_TOKEN_PARAMETER);
            if (StringUtils.hasText(refreshToken)) {
                CredentialQuery query = CredentialQuery.builder()
                        .refreshToken(refreshToken)
                        .build();
                var user = userRepository.findByCredential(query);
                if (user.isEmpty()) {
                    throw new InvalidBearerTokenException("Invalid refresh token : %s".formatted(refreshToken));
                }

                Credential credential = user.get().getCredential();
                if (credential == null) {
                    throw new InvalidBearerTokenException("Invalid refresh token : %s".formatted(refreshToken));
                }
                if (credential.isRefreshTokenExpired()) {
                    throw new AccountExpiredException("Refresh token has expired");
                }

                credential = new Credential();
                user.get().issueCredential(credential);

                userRepository.save(user.get());

                CredentialDto dto = credentialConverter.convert(credential);
                doJsonResponse(response, Result.succeed(dto));
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    /**
     * 是否有效的 url
     *
     * @param request 请求信息
     * @return true：有效的
     */
    private boolean isAvailableUrl(@NonNull HttpServletRequest request) {
        return matcher.match(PATTERN, request.getRequestURI());
    }
}
