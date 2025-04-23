package com.joao.neto.ufcg.course.entities;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {

     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {

    }

    public Order(Long id, Instant date, OrderStatus status, User client) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
