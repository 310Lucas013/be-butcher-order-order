package com.lucas.order.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Order_Product")
public class OrderProduct {
    @Id
    @Column(name = "product_id")
    private long productId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "amount")
    private int amount;

    public OrderProduct() {

    }
}
