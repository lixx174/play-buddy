package com.qinghaotech.application.model.command;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 陪玩师修改
 *
 * @author Jinx
 */
@Getter
@Setter
public class ModifyCompanionCommand {
    /**
     * 陪玩师唯一标识
     */
    private Integer id;
    /**
     * 支持游戏
     */
    private Set<Integer> gameIds;
    /**
     * 星级
     */
    private Float starLevel;
    /**
     * 状态
     */
    private String status;
}
