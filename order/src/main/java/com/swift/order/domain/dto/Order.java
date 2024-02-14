package com.swift.order.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Guests> getGuests() {
        return guests;
    }

    public void setGuests(List<Guests> guests) {
        this.guests = guests;
    }
}
