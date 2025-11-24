package com.qinghaotech.domain.primitive;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Jinx
 */
@Getter
@RequiredArgsConstructor
public enum Status {

    /**
     * 开启
     */
    ENABLE,
    /**
     * 关闭
     */
    DISABLE,
    /**
     * 禁用
     */
    FORBIDDEN
}
