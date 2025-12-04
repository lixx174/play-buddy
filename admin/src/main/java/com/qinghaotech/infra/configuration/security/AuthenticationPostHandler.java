package com.qinghaotech.infra.configuration.security;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.converter.CredentialConverter;
import com.qinghaotech.application.model.dto.CredentialDto;
import com.qinghaotech.application.support.UserDetail;
import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.primitive.Credential;
import com.qinghaotech.domain.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import static com.qinghaotech.infra.configuration.support.ManualResponseSupport.doJsonResponse;

/**
 * @author Jinx
 */
@RequiredArgsConstructor
public class AuthenticationPostHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    private final UserRepository userRepository;
    private final CredentialConverter credentialConverter;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) {
        throw exception;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) {
        if (authentication.getPrincipal() instanceof UserDetail(User user)) {
            Credential credential = user.getCredential();
            if (credential == null || credential.isAccessTokenExpired()) {
                credential = new Credential();
                user.issueCredential(credential);
                userRepository.save(user);
            }

            CredentialDto dto = credentialConverter.convert(credential);
            doJsonResponse(response, Result.succeed(dto));
        } else {
            throw new AuthenticationServiceException("Illegal principal");
        }
    }
}
