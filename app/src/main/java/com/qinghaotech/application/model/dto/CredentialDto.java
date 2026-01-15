package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Jinx
 */
@Getter
@Setter
public class CredentialDto {

    /**
     * 访问凭证
     */
    private String accessToken;
    /**
     * 刷新凭证
     */
    private String refreshToken;
    /**
     * 访问token 过期时间
     */
    private LocalDateTime accessTokenExpireAt;
    /**
     * 刷新token 过期时间
     */
    private LocalDateTime refreshTokenExpireAt;
}
