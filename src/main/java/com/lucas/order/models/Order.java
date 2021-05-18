package com.lucas.order.models;

import com.lucas.order.models.dto.OrderDto;
import com.lucas.order.models.dto.OrderProductDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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

    public Order(OrderDto orderDto) {
        this.orderStatus = OrderStatus.CREATED;
        this.pickupDate = orderDto.getPickupDate();
        //List<OrderProduct> orderProducts = new ArrayList<>();
        this.products = new ArrayList<>();
//        for(OrderProductDto opd: orderDto.getProducts()) {
//            OrderProduct orderProduct = new OrderProduct();
//            orderProduct.setProductId(opd.getProductId());
//            orderProduct.setAmount(opd.getAmount());
//             orderProduct.setOrder(this);
//            this.products.add(orderProduct);
//        }
        //this.products = orderProducts;
        this.customerId = orderDto.getCustomerId();
        this.locationId = orderDto.getLocationId();
        this.butcherId = orderDto.getButcherId();
    }
}
