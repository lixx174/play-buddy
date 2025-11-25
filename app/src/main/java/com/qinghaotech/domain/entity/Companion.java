package com.qinghaotech.domain.entity;

import com.qinghaotech.domain.entity.companion.CompanionLevel;
import com.qinghaotech.domain.entity.companion.CompanionPrice;
import com.qinghaotech.domain.entity.companion.CompanionTag;
import com.qinghaotech.domain.primitive.Game;
import com.qinghaotech.domain.primitive.Status;

import java.util.List;

/**
 * @author Jinx
 */
public class Companion {

    private Integer id;

    /**
     * 持有系统user引用，陪玩师的基本信息使用user的基本信息。
     */
    private Integer userId;

    /**
     * 陪玩师的账号状态不会影响到关联user的状态，但是user会影响到陪玩师。
     */
    private Status status;

    private CompanionLevel level;
    private CompanionPrice price;
    private List<CompanionTag> tags;
    private List<Game> games;
}
