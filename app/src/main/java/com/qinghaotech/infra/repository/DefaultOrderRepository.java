package com.qinghaotech.infra.repository;

import com.qinghaotech.domain.entity.order.Order;
import com.qinghaotech.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

/**
 * @author Jinx
 */
@Component
public class DefaultOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {

    }
}
