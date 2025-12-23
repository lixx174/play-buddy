package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class UserSummaryDto extends BaseDto {

    /**
     * 名字
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 状态
     */
    private String status;
}
