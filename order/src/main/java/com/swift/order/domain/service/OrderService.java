package com.swift.order.domain.service;

import com.swift.order.application.Response;
import com.swift.order.domain.dto.Guests;
import com.swift.order.domain.dto.Order;
import com.swift.order.domain.dto.OrderItem;
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
    public Boolean deleteOrder(long orderId){
    Order order = this.findById(orderId);
    List<Guests> guests = order.getGuests();
    if(guests != null) {
        for (int i = 0; i < guests.size(); i++) {
            orderRepository.deleteGuests(guests.get(i).getId());
        }
    }
    List<OrderItem> items = order.getItems();
    if(items != null) {
        for (int i = 0; i < items.size(); i++) {
            orderRepository.deleteItems(items.get(i).getId());
        }
        orderRepository.deleteOrder(orderId);
    }
    return true;
    }
}
