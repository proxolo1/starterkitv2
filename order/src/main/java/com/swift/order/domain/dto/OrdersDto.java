package com.swift.order.domain.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public record OrdersDto (
     Long id,
    @NotNull(message = "server should not be empty")
    @Size(min = 1, max = 30, message = "invalid server name")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid server name")
     String server,
    @NotNull(message = "date should not be empty")
    @Size(min = 1, max = 30, message = "invalid date time")
    @DateTimeFormat
     String dateTime,
    @Size(min = 1, max = 30, message = "Invalid table number")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid table number")
    @NotNull(message = "Table number is missing")
     String tableNumber,
    @Size(min = 1, max = 30, message = "Invalid seats")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid seats")
    @NotNull(message = "Seats is missing")
     String seats,
    @Size(min = 1, max = 30, message = "Invalid check number")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid check number")
    @NotNull(message = "Check number is missing")
     String checkNumber,
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
     List<OrderItem> items,
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
     List<Guests> guests
){
    public Order mapper() {
        Order order = new Order();
        order.setTableNumber(this.tableNumber);
        order.setSeats(this.seats);
        order.setServer(this.server);
        order.setDateTime(this.dateTime);
        order.setCheckNumber(this.checkNumber);
        order.setGuests(this.guests);
        order.setItems(this.items);
        return order;
    }
}
