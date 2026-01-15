package com.qinghaotech.domain.primitive.order;

import org.springframework.util.Assert;

/**
 * @param variantId 商品唯一标识
 * @param count     购买数量
 * @author Jinx
 */
public record OrderItem(Integer variantId, Integer count) {

    public OrderItem {
        Assert.notNull(variantId, "variantId is null");
        Assert.notNull(count, "count is null");
        Assert.isTrue(count > 0, "Illegal count: %s".formatted(count));
    }
}
