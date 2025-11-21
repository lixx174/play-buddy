package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.application.Result;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.nio.file.AccessDeniedException;

import static com.qinghaotech.infra.configuration.support.ManualResponseSupport.doJsonResponse;


/**
 * @author Jinx
 */
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (AuthenticationException | IllegalArgumentException authenticationException) {
            doJsonResponse(
                    response,
                    Result.fail(HttpStatus.FORBIDDEN.value(), authenticationException.getMessage())
            );
        } catch (AccessDeniedException accessDeniedException) {
            doJsonResponse(
                    response,
                    Result.fail(HttpStatus.UNAUTHORIZED.value(), accessDeniedException.getMessage())
            );
        } catch (Exception e) {
            doJsonResponse(
                    response,
                    Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage())
            );
        }
    }
}
