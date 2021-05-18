package com.lucas.order.services;

import com.lucas.order.models.Order;
import com.lucas.order.models.OrderProduct;
import com.lucas.order.models.OrderStatus;
import com.lucas.order.models.dto.OrderDto;
import com.lucas.order.models.dto.OrderProductDto;
import com.lucas.order.repositories.OrderProductRepository;
import com.lucas.order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    public Order createOrder(OrderDto orderDto) {
        Order order = new Order(orderDto);
        Order result = saveOrder(order);
        for(OrderProductDto opd: orderDto.getProducts()) {
            OrderProduct orderProduct = new OrderProduct(opd, result);
            OrderProduct rop = this.saveOrderProduct(orderProduct);
            System.out.println(rop);
            System.out.println(rop.toString());
        }
        return result;
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public List<Order> getOrdersByCreatedStatus(Long butcherId) {
        return orderRepository.findAllByButcherIdAndOrderStatusEquals(butcherId, OrderStatus.CREATED);
    }

    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }
}
