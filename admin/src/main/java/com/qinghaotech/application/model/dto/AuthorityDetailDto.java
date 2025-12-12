package com.qinghaotech.application.model.dto;

import com.qinghaotech.domain.entity.authority.AuthorityType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class AuthorityDetailDto {
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 父权限id
     */
    private Integer parentId;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限类型
     */
    private AuthorityType type;
    /**
     * 路由
     */
    private String path;
    /**
     * 权限标识
     */
    private String permission;
    /**
     * 排序号
     */
    private Integer sortNo;
}
