package com.driagon.springdatajpa.transactions.app.repositories;

import com.driagon.springdatajpa.transactions.app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {


}