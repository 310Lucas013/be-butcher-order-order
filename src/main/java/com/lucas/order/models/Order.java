package com.lucas.order.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Order() {

    }
}
