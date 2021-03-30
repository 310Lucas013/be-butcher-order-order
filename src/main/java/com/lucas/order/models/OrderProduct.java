package com.lucas.order.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Order_Product")
public class OrderProduct {
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "Order_id")
    private Order order;

    public OrderProduct() {

    }
}
