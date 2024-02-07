package com.swift.order.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderItem {
    private Integer Id;
    private String itemNumber;
    private String price;
    private String quality;
}
