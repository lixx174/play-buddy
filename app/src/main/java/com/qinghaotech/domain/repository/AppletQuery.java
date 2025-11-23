package com.qinghaotech.domain.repository;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Jinx
 */
@Getter
@Builder
public class AppletQuery {

    private String openId;
    private String unionId;
}
