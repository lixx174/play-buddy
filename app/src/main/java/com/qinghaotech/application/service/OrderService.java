package com.qinghaotech.application.service;

import com.qinghaotech.application.model.command.CreateOrderCommand;
import com.qinghaotech.application.support.SecuritySupport;
import com.qinghaotech.domain.entity.companion.Companion;
import com.qinghaotech.domain.entity.game.Game;
import com.qinghaotech.domain.entity.order.Order;
import com.qinghaotech.domain.entity.product.Variant;
import com.qinghaotech.domain.entity.user.User;
import com.qinghaotech.domain.primitive.order.BuyerContact;
import com.qinghaotech.domain.primitive.order.OrderItem;
import com.qinghaotech.domain.repository.CompanionRepository;
import com.qinghaotech.domain.repository.GameRepository;
import com.qinghaotech.domain.repository.OrderRepository;
import com.qinghaotech.domain.repository.ProductRepository;
import com.qinghaotech.domain.repository.UserRepository;
import com.qinghaotech.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final CompanionRepository companionRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final OrderDomainService orderDomainService;

    public void create(CreateOrderCommand command) {
        OrderItem orderItem = new OrderItem(command.getVariantId(), command.getVariantCount());
        var buyerContact = new BuyerContact(command.getGameContactInfo(), command.getContactInfo(), command.getRemark());

        Game game = gameRepository.findByIdOrElseThrow(command.getGameId());
        Variant variant = productRepository.findByIdOrElseThrow(command.getVariantId());
        Companion companion = companionRepository.findByIdOrElseThrow(command.getCompanionId());
        User buyer = userRepository.findByIdOrElseThrow(SecuritySupport.getUserId());

        Order order = orderDomainService.create(game, variant, orderItem, companion, buyer, buyerContact);

        orderRepository.save(order);
    }
}
