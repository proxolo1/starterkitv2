package com.swift.order.application;

import com.swift.order.domain.dto.Order;
import com.swift.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping()
    private ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @PostMapping
    private ResponseEntity <Order> save(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }
}
