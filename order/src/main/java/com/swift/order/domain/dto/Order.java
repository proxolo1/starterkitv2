package com.swift.order.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String server;

    @JsonFormat(pattern = "yyyy-MMM-dd HH:mm:ss")
    private String dateTime;
    private String tableNumber;
    private String seats;
    private String checkNumber;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "order_id")
    private List<OrderItem> items = new ArrayList<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "order_id")
    private List<Guests> guests = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", server='" + server + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", tableNumber='" + tableNumber + '\'' +
                ", seats='" + seats + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                ", items=" + items +
                ", guests=" + guests +
                '}';
    }
}
