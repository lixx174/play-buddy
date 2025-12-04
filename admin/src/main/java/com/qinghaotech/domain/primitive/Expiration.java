package com.qinghaotech.domain.primitive;

import java.time.LocalDateTime;

/**
 * @author Jinx
 */
public record Expiration(LocalDateTime expiredAt) {

    /**
     * 是否已过期
     *
     * @return true：已过期
     */
    public boolean isExpired() {
        return expiredAt != null && expiredAt.isBefore(LocalDateTime.now());
    }
}
