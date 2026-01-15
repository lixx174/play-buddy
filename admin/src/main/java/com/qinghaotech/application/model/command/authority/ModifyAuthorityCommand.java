package com.qinghaotech.application.model.command.authority;

import lombok.Getter;
import lombok.Setter;

/**
 * 权限修改模型
 *
 * @author Jinx
 */
@Getter
@Setter
public class ModifyAuthorityCommand {
    /**
     * 权限唯一标识
     */
    private Integer id;
    /**
     * 父权限唯一标识
     */
    private Integer parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * 路由
     */
    private String path;
    /**
     * 标识
     */
    private String permission;
    /**
     * 排序号
     */
    private Integer sortNo;
}
