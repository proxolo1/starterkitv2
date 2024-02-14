package com.swift.order.domain.service;

import com.swift.order.application.Response;
import com.swift.order.infrastructure.entity.Guests;
import com.swift.order.domain.dto.OrdersDto;
import com.swift.order.infrastructure.entity.Order;
import com.swift.order.infrastructure.entity.OrderItem;
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
    public Response saveOrder(OrdersDto order) {
        orderRepository.save(order);
        return Response.builder().id(order.id()).message("SUCCESS").build();
    }
    public Order findById(long id){
        return orderRepository.findOrderById(id);
    }
    public Response deleteOrder(long orderId){
    Order order = this.findById(orderId);
    List<Guests> guests = order.getGuests();
    if(guests != null) {
        for (Guests guest : guests) {
            orderRepository.deleteGuests(guest.getId());
        }
    }
    List<OrderItem> items = order.getItems();
    if(items != null) {
        for (OrderItem item : items) {
            orderRepository.deleteItems(item.getId());
        }
        orderRepository.deleteOrder(orderId);
    }
    return Response.builder().id(orderId).message("Deleted successfully").build();
    }
}
