package com.lucas.order.models;

import com.lucas.order.models.dto.OrderProductDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(OrderProductId.class)
@Table(name = "Order_Product")
public class OrderProduct {
    @Id
    @Column(name = "product_id")
    private Long productId;
    @Id
    @Column(name = "order_product_id")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "amount")
    private int amount;

    public OrderProduct() {

    }

    public OrderProduct(OrderProductDto orderProductDto, Order order) {
        this.productId = orderProductDto.getProductId();
        this.order = order;
        this.orderId = order.getId();
        this.amount = orderProductDto.getAmount();
    }
}
