package com.swift.order.infrastructure;
import com.swift.order.domain.dto.Order;
import com.swift.order.domain.repository.GuestRepository;
import com.swift.order.domain.repository.OrderItemRepository;
import com.swift.order.domain.repository.OrderRepository;
import com.swift.order.infrastructure.repositories.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final GuestRepository guestRepository;
    private final OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepositoryImpl(OrderJpaRepository repo, GuestRepository guestRepository, OrderItemRepository orderItemRepository) {
        this.orderJpaRepository = repo;
        this.guestRepository = guestRepository;
        this.orderItemRepository = orderItemRepository;
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
        return orderJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public Boolean deleteOrder(long id) {
        return false;
    }

    @Override
    public Boolean updateServerName(Order order, Long id) {
        return null;
    }
}
