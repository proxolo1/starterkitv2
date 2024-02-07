package com.swift.order.domain.service;

import com.swift.order.application.Response;
import com.swift.order.domain.dto.Order;
import com.swift.order.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order findById(long id){
        return orderRepository.findOrderById(id);
    }
}
