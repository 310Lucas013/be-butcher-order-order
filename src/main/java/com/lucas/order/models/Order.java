package com.lucas.order.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "pickup_date")
    private Date pickupDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @OneToMany(mappedBy = "order", targetEntity = OrderProduct.class)
    private List<OrderProduct> products;
    @Column(name = "location_id")
    private long locationId;
    @Column(name = "customer_id")
    private long customerId;

    public Order() {

    }
}
