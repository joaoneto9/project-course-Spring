package com.joao.neto.ufcg.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {

     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private Integer status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Paymant paymant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order") // o orderItem tem um id e dentro dele tem um Order.
    private Set<OrderItem> items = new HashSet<>();

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

    public Set<OrderItem> getItems() {
        return items;
    }

    public Paymant getPaymant() {
        return paymant;
    }

    public void setPaymant(Paymant paymant) {
        this.paymant = paymant;
    }

    public Double getTotal() {
        return items.stream()
                .map(OrderItem::getSubTotal)
                .reduce(0.0, Double::sum);
    }
}
