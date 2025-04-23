package com.joao.neto.ufcg.course.entities;

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
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {

    }

    public Order(Long id, Instant date, User client) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.status = OrderStatus.WAITING_PAYMENT.getI();
    }

    public Order(Long id, Instant date, User client, OrderStatus status) {
        this(id, date, client);
        setStatus(status);
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
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null)
            this.status = status.getI();
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
