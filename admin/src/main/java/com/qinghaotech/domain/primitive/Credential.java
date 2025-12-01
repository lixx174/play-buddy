package com.qinghaotech.domain.primitive;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Jinx
 */
@Getter
public class Credential {

    private final String accessToken;
    private final String refreshToken;
    private final LocalDateTime accessTokenExpireAt;
    private final LocalDateTime refreshTokenExpireAt;

    public Credential() {
        accessToken = UUID.randomUUID().toString();
        refreshToken = UUID.randomUUID().toString();
        accessTokenExpireAt = LocalDateTime.now().plusDays(1);
        refreshTokenExpireAt = LocalDateTime.now().plusDays(7);
    }

    public boolean isAccessTokenExpired() {
        return LocalDateTime.now().isAfter(accessTokenExpireAt);
    }

    public boolean isRefreshTokenExpired() {
        return LocalDateTime.now().isAfter(refreshTokenExpireAt);
    }
}
