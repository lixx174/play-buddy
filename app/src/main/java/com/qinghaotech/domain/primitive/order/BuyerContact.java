package com.qinghaotech.domain.primitive.order;

import org.springframework.util.Assert;

/**
 * @param game   游戏昵称/ID
 * @param mobile 手机号
 * @param remark 备注
 * @author Jinx
 */
public record BuyerContact(String game, String mobile, String remark) {

    public BuyerContact {
        Assert.hasText(game, "游戏昵称/ID为空");
        Assert.hasText(mobile, "Mobile is empty");
        Assert.isTrue(mobile.matches("^1[3-9]\\d{9}$"), "Illegal Mobile: %s".formatted(mobile));
    }
}
