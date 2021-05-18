package com.lucas.order.models;

import java.io.Serializable;

public class OrderProductId implements Serializable {
    private Long productId;
    private Long orderId;

    public OrderProductId() {
    }

    public OrderProductId(Long productId, Long orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

}
