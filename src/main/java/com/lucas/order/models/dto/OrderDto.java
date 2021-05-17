package com.lucas.order.models.dto;

import com.lucas.order.models.OrderProduct;
import com.lucas.order.models.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Date pickupDate;
    private List<OrderProductDto> products;
    private long locationId;
    private long customerId;
    private long butcherId;
}
