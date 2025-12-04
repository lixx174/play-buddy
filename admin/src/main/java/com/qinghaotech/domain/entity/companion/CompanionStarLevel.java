package com.qinghaotech.domain.entity.companion;

import org.springframework.util.Assert;

/**
 * @author Jinx
 */
public record CompanionStarLevel(Float value) {

    public CompanionStarLevel {
        Assert.notNull(value, "星级为空");
        Assert.isTrue(value >= 0 && value <= 5, "非法星级: %s".formatted(value));
    }
}
