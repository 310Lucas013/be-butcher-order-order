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
    @JoinColumn(name = "id")
    private Order order;

    public OrderProduct() {

    }
}
