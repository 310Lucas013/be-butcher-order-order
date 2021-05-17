package com.lucas.order.services;

import com.lucas.order.models.Order;
import com.lucas.order.models.OrderProduct;
import com.lucas.order.models.OrderStatus;
import com.lucas.order.models.dto.OrderDto;
import com.lucas.order.models.dto.OrderProductDto;
import com.lucas.order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        order.setPickupDate(orderDto.getPickupDate());
        List<OrderProduct> orderProducts = new ArrayList<>();
        for(OrderProductDto opd: orderDto.getProducts()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProductId(opd.getProductId());
            orderProduct.setAmount(opd.getAmount());
            orderProducts.add(orderProduct);
        }
        order.setProducts(orderProducts);
        order.setCustomerId(orderDto.getCustomerId());
        order.setLocationId(orderDto.getLocationId());
        return saveOrder(order);
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public List<Order> getOrdersByCreatedStatus(Long butcherId) {
        return orderRepository.findAllByButcherIdAndOrderStatusEquals(butcherId, OrderStatus.CREATED);
    }
}
