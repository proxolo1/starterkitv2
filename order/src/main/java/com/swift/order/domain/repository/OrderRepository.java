package com.swift.order.domain.repository;

import com.swift.order.domain.dto.OrdersDto;
import com.swift.order.infrastructure.entity.Order;

import java.util.List;
public interface OrderRepository {
    OrdersDto save(OrdersDto order);
    List<Order>getAllOrders();
    Order findOrderById(long id);
    Boolean deleteOrder(long id);
    Boolean updateServerName(Order order, Long id);
    Boolean deleteGuests(Integer id);

    boolean deleteItems(Integer id);
}
