package com.joao.neto.ufcg.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joao.neto.ufcg.course.entities.pk.OrdemItemPk;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    private static final long serilVersionUID = 1L;

    @EmbeddedId // id da classe Embedded
    private OrdemItemPk id = new OrdemItemPk();

    private Integer quantity;
    private Double price;

    public OrderItem() {

    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        setOrder(order);
        setPrdouct(product);
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setPrdouct(Product product) {
        id.setProduct(product);
    }

    public Double getSubTotal() {
        return quantity * price;
    }
}
