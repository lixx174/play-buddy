package com.qinghaotech.domain.repository;

import lombok.Builder;
import lombok.Getter;

/**
 * @author jinx
 */
@Getter
@Builder
public class CredentialQuery {

    private String accessToken;
    private String refreshToken;
}
