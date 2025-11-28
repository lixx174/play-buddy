package com.qinghaotech.domain.service;

import com.qinghaotech.domain.entity.Companion;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.entity.order.Order;
import com.qinghaotech.domain.primitive.Game;
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


    public Order create(Game game, OrderItem item, Companion companion, User buyer, BuyerContact buyerContact) {


        return Order.builder()
                .no()
                .game(game)
                .companion(companion)
                .item(item)
                .buyer(buyer)
                .status(OrderStatus.PENDING)
                .buyerContact(buyerContact)
                .build();

    }


}
