package com.qinghaotech.application.model.command;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 陪玩师新增
 *
 * @author Jinx
 */
@Getter
@Setter
public class CreateCompanionCommand {

    /**
     * 小程序用户id
     */
    private Integer wechatUserId;
    /**
     * 支持游戏
     */
    private Set<Integer> gameIds;
    /**
     * 星级
     */
    private Float starLevel;
}
