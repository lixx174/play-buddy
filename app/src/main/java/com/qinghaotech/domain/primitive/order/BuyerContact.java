package com.qinghaotech.domain.primitive.order;

import org.springframework.util.Assert;

/**
 * 购买人联系方式
 *
 * @param gameId 游戏昵称/ID
 * @param mobile 手机号
 * @param remark 备注
 * @author Jinx
 */
public record BuyerContact(String gameId, String mobile, String remark) {

    public BuyerContact {
        Assert.hasText(gameId, "游戏昵称/ID为空");
        Assert.hasText(mobile, "Mobile is empty");
        Assert.isTrue(mobile.matches("^1[3-9]\\d{9}$"), "Illegal Mobile: %s".formatted(mobile));
    }
}
