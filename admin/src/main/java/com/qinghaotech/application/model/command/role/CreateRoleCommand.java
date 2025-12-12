package com.qinghaotech.application.model.command.role;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author Jinx
 */
@Getter
@Setter
public class CreateRoleCommand {
    /**
     * 名字
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 权限id集
     */
    private Set<Integer> authorityIds;
}
