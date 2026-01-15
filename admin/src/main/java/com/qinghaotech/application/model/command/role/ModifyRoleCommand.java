package com.qinghaotech.application.model.command.role;

import com.qinghaotech.domain.primitive.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author Jinx
 */
@Getter
@Setter
public class ModifyRoleCommand {
    /**
     * 角色唯一标识
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 角色状态
     */
    private Status status;
    /**
     * 权限唯一标识集
     */
    private Set<Integer> authorityIds;
}
