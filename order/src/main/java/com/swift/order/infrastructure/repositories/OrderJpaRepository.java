package com.swift.order.infrastructure.repositories;

import com.swift.order.domain.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
