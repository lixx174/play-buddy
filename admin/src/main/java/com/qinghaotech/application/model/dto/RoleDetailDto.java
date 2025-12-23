package com.qinghaotech.application.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Jinx
 */
@Getter
@Setter
public class RoleDetailDto extends BaseDto {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色备注
     */
    private String remark;
    /**
     * 角色状态
     */
    private String status;
    /**
     * 角色权限
     */
    private Collection<AuthorityTreeDto> authorities;
}
