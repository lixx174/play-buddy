package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.application.Result;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

import static com.qinghaotech.infra.configuration.support.ManualResponseSupport.doJsonResponse;


/**
 * @author Jinx
 */
@Slf4j
@RequiredArgsConstructor
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("An exception occurred on defaultSecurityFilterChain", e);
            doJsonResponse(response, translateException(e));
        }
    }

    private Result<?> translateException(Exception e) {
        return switch (e) {
            case AuthenticationException ex -> Result.fail(HttpStatus.FORBIDDEN.value(), ex.getMessage());
            case IllegalArgumentException ex -> Result.fail(HttpStatus.FORBIDDEN.value(), ex.getMessage());
            case AccessDeniedException ex -> Result.fail(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
            default -> Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        };
    }
}
