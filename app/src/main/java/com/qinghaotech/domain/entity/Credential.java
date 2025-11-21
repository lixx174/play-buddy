package com.qinghaotech.domain.entity;

import java.time.LocalDateTime;

/**
 * @author Jinx
 */
public class Credential {

    private Integer id;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime accessTokenExpireAt;
    private LocalDateTime refreshTokenExpireAt;
}
