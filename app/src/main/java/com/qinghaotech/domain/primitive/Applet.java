package com.qinghaotech.domain.primitive;

import org.springframework.util.Assert;

/**
 * @param openId  小程序下用户的唯一id
 * @param unionId 开放平台下用户的唯一id（eg：微信开放平台）
 * @author Jinx
 */
public record Applet(String openId, String unionId) {

    public Applet {
        Assert.hasText(openId, "openId cannot be empty");
        Assert.hasText(unionId, "unionId cannot be empty");
    }
}
