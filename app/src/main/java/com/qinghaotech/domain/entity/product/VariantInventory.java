package com.qinghaotech.domain.entity.product;

import org.springframework.util.Assert;

/**
 * @author Jinx
 */
public record VariantInventory(Integer value) {

    public VariantInventory {
        Assert.notNull(value, "库存不能为null");
        Assert.isTrue(value >= 0, "库存不能为负");
    }

    public boolean isEnough(int count) {
        return value >= count;
    }
}
