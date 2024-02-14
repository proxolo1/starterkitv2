package com.swift.order.infrastructure.repositories;

import com.swift.order.infrastructure.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Integer> {
}
