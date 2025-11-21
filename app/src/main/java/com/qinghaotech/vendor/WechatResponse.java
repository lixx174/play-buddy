package com.qinghaotech.vendor;

import org.springframework.util.StringUtils;

/**
 * @author Jinx
 */
public interface WechatResponse {

    String getErrCode();

    String getErrMsg();

    default boolean isSuccess() {
        return !StringUtils.hasText(getErrCode()) && !StringUtils.hasText(getErrMsg());
    }
}
