package com.qinghaotech.application.model.command;

import com.qinghaotech.domain.primitive.Game;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jinx
 */
@Getter
@Setter
public class OrderCreateCommand {

    /**
     * 陪玩师id
     */
    private Integer companionId;
    /**
     * 游戏
     */
    private Game game;
    /**
     * 所选商品id
     */
    private Integer variantId;
    /**
     * 下单数量
     */
    private Integer variantCount;
    /**
     * 游戏昵称/ID
     */
    private String gameContactInfo;
    /**
     * 联系方式
     */
    private String contactInfo;
    /**
     * 备注
     */
    private String remark;
}
