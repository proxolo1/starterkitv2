package com.swift.order.application;

import lombok.Builder;
import lombok.Data;

@Builder
public record Response (
    long id,
    String message
)
{
}
