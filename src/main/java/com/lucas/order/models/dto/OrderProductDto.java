package com.lucas.order.models.dto;

import lombok.Data;

@Data
public class OrderProductDto {
    private long productId;
    private int amount;
}
