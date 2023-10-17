package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderTrackingNumber(String orderTrackingNumber);
}