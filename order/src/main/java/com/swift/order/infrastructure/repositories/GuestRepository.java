package com.swift.order.infrastructure.repositories;

import com.swift.order.infrastructure.entity.Guests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guests, Integer> {
}
