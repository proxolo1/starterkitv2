package com.swift.order.infrastructure;

import com.swift.order.domain.dto.Order;
import com.swift.order.infrastructure.repositories.OrderItemJpaRepository;
import com.swift.order.domain.repository.OrderRepository;
import com.swift.order.infrastructure.repositories.GuestRepository;
import com.swift.order.infrastructure.repositories.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    private OrderItemJpaRepository orderItemRepository;
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

    @Override
    public Boolean deleteGuests(Integer id) {
        guestRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteItems(Integer id) {
        orderItemRepository.deleteById(id);
        return true;
    }
}
