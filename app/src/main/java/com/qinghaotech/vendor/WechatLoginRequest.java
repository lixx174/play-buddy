package com.qinghaotech.vendor;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Jinx
 */
@Getter
@Builder
public class WechatLoginRequest {

    private final String appId;

    private final String appSecret;

    private final String loginCode;

    private final String grantType = "authorization_code";
}
