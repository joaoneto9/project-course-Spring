package com.joao.neto.ufcg.course.entities;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int i;

    private OrderStatus(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static OrderStatus valueOf(int i) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getI() == i)
                return value;
        }

        throw new IllegalArgumentException("codigo invalido");
    }
}
