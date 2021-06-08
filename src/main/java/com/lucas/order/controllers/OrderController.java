package com.lucas.order.controllers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lucas.order.models.HibernateProxyTypeAdapter;
import com.lucas.order.models.Order;
import com.lucas.order.models.dto.OrderDto;
import com.lucas.order.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        Gson gson = initiateGson();
        Order order = orderService.createOrder(orderDto);
        System.out.println(order);
        String result = gson.toJson(order);
        return new ResponseEntity<String>(result, HttpStatus.CREATED);
    }

    @GetMapping(value = "/created-status/{butcherId}")
    public ResponseEntity<?> getOrdersByCreatedStatus(@PathVariable("butcherId") Long butcherId) {
        System.out.println("Order Created Status Entered");
        Gson gson = initiateGson();
        List<Order> orders = orderService.getOrdersByCreatedStatus(butcherId);
        System.out.println(orders);
        String result = gson.toJson(orders);
        return new ResponseEntity<String>(result, HttpStatus.CREATED);
    }

    @PostMapping(value = "/accept-order")
    public ResponseEntity<?> acceptOrder(@RequestBody Order order) {
        Gson gson = initiateGson();
        Order updatedOrder = orderService.acceptOrder(order);
        String result = gson.toJson(updatedOrder);
        return new ResponseEntity<String>(result, HttpStatus.CREATED);

    }

    @PostMapping(value = "/decline-order")
    public ResponseEntity<?> declineOrder(@RequestBody Order order) {
        Gson gson = initiateGson();
        Order updatedOrder = orderService.declineOrder(order);
        String result = gson.toJson(updatedOrder);
        return new ResponseEntity<String>(result, HttpStatus.CREATED);
    }

    private Gson initiateGson() {
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        boolean exclude = false;
                        try {
                            exclude = EXCLUDE.contains(f.getName());
                        } catch (Exception ignore) {
                        }
                        return exclude;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                });
        return b.create();
    }

    private static final List<String> EXCLUDE = new ArrayList<>() {{
        add("order");
    }};
}
