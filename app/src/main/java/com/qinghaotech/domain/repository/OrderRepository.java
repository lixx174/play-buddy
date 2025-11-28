package com.qinghaotech.domain.repository;

import com.qinghaotech.domain.entity.order.Order;

/**
 * @author Jinx
 */
public interface OrderRepository {

    void save(Order order);
}
