package com.qinghaotech.domain.entity.order;

import com.qinghaotech.domain.entity.Companion;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.primitive.Game;
import com.qinghaotech.domain.primitive.OrderStatus;
import com.qinghaotech.domain.primitive.order.BuyerContact;
import com.qinghaotech.domain.primitive.order.OrderItem;
import lombok.Builder;
import org.springframework.util.Assert;

/**
 * @author Jinx
 */
public class Order {

    private final Integer id;

    private final String no;

    private final Game game;

    private final Companion companion;

    private final OrderItem item;

    private final User buyer;

    private final OrderStatus status;

    private final BuyerContact buyerContact;

    @Builder
    private Order(Integer id, String no, Game game, Companion companion, OrderItem item, User buyer, OrderStatus status, BuyerContact buyerContact) {
        Assert.hasText(no, "no is empty");
        Assert.notNull(game, "game is null");
        Assert.notNull(companion, "companion is null");
        Assert.notNull(item, "item is null");
        Assert.notNull(buyer, "buyer is null");
        Assert.notNull(status, "status is null");
        Assert.notNull(buyerContact, "buyerContact is null");

        this.id = id;
        this.no = no;
        this.game = game;
        this.companion = companion;
        this.item = item;
        this.buyer = buyer;
        this.status = status;
        this.buyerContact = buyerContact;
    }
}
