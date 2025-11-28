package com.qinghaotech.application.service;

import com.qinghaotech.application.model.command.OrderCreateCommand;
import com.qinghaotech.application.support.SecuritySupport;
import com.qinghaotech.domain.entity.Companion;
import com.qinghaotech.domain.entity.User;
import com.qinghaotech.domain.entity.order.Order;
import com.qinghaotech.domain.entity.product.Variant;
import com.qinghaotech.domain.repository.CompanionRepository;
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
    private final OrderDomainService orderDomainService;

    public void create(OrderCreateCommand command) {
        Variant variant = productRepository.findByIdSafely(command.getVariantId());
        Companion companion = companionRepository.findByIdSafely(command.getCompanionId());
        User buyer = userRepository.findByIdSafely(SecuritySupport.getUserId());

        Order order = orderDomainService.create(
                variant.get(),
                companion.get(),
                buyer.get()
        );

        orderRepository.save(order);
    }
}
