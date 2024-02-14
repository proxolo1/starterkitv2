package com.swift.order.infrastructure;

import com.swift.order.domain.dto.OrdersDto;
import com.swift.order.infrastructure.entity.Order;
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
    public OrdersDto save(OrdersDto order) {
        return orderToDTO(this.orderJpaRepository.save(order.mapper()));
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderJpaRepository.findAll();
    }

    @Override
    public Order findOrderById(long id) {
        return orderJpaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Order id " + id + " not found"));
    }

    @Override
    public Boolean deleteOrder(long id) {
        Order order = orderJpaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Order id "+ id + " not found"));
        orderJpaRepository.delete(order);
        return true;
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
    public OrdersDto orderToDTO(Order order) {
        return new OrdersDto(
                order.getId(),
                order.getServer(),
                order.getDateTime(),
                order.getTableNumber(),
                order.getSeats(),
                order.getCheckNumber(),
                order.getItems(),
                order.getGuests()
        );
    }
}
