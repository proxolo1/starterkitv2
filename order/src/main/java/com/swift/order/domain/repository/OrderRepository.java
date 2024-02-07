package com.swift.order.domain.repository;

import com.swift.order.domain.dto.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface OrderRepository {
    Order save(Order order);
    List<Order>getAllOrders();
    Order findOrderById(long id);
    Boolean deleteOrder(long id);
    Boolean updateServerName(Order order, Long id);


}
