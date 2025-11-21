package com.qinghaotech.vendor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author Jinx
 */
@Getter
public class WechatLoginRequest {

    @JsonProperty("appid")
    private String appId;

    @JsonProperty("secret")
    private String appSecret;

    @JsonProperty("js_code")
    private String loginCode;

    @JsonProperty("grant_type")
    private final String grantType = "authorization_code";

    public WechatLoginRequest(String appId, String appSecret, String loginCode) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.loginCode = loginCode;
    }
}
