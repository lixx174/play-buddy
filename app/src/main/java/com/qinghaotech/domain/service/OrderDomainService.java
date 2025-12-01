package com.qinghaotech.domain.service;

import com.qinghaotech.domain.entity.companion.Companion;
import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.entity.order.Order;
import com.qinghaotech.domain.entity.product.Variant;
import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.primitive.OrderStatus;
import com.qinghaotech.domain.primitive.order.BuyerContact;
import com.qinghaotech.domain.primitive.order.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class OrderDomainService {

    private final IdGenerator uuidGenerator;


    public Order create(Game game, Variant variant, OrderItem item, Companion companion, User buyer, BuyerContact buyerContact) {
        game.assertEnabled();

        variant.deductInventory(item.count());

        companion.assertEnabled();
        companion.assertSupport(game);

        buyer.assertEnabled();

        return Order.builder()
                .no(uuidGenerator.generateOrderNumber())
                .game(game)
                .companion(companion)
                .item(item)
                .buyer(buyer)
                .status(OrderStatus.PENDING)
                .buyerContact(buyerContact)
                .build();
    }
}
