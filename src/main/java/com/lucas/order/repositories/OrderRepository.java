package com.lucas.order.repositories;

import com.lucas.order.models.Order;
import com.lucas.order.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByButcherIdAndOrderStatusEquals(Long butcherId, OrderStatus orderStatus);
}
