package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
@Setter
public class RoleSummaryDto extends BaseDto {
    /**
     * 角色名字
     */
    private String name;
    /**
     * 角色备注
     */
    private String remark;
    /**
     * 角色权限集
     */
    private Collection<AuthorityDto> authorities;
}
