package com.lucas.order.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "[order]")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "pickup_date")
    private Date pickupDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order", targetEntity = OrderProduct.class)
    private List<OrderProduct> products;
    @Column(name = "location_id")
    private long locationId;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "butcher_id")
    private long butcherId;

    public Order() {

    }
}
