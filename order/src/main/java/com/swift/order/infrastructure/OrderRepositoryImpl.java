package com.swift.order.infrastructure;
import com.swift.order.domain.dto.Order;
import com.swift.order.domain.repository.OrderRepository;
import com.swift.order.infrastructure.repositories.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    @Autowired
    OrderRepositoryImpl(OrderJpaRepository repo) {
        this.orderJpaRepository = repo;
    }
    @Override
    public Order save(Order order) {
        return this.orderJpaRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderJpaRepository.findAll();
    }

    @Override
    public Order findOrderById(long id) {
        return null;
    }

    @Override
    public Boolean deleteOrder(long id) {
        return null;
    }

    @Override
    public Boolean updateServerName(Order order, Long id) {
        return null;
    }
}
