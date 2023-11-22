package com.driagon.springdatajpa.transactions.app.repositories;

import com.driagon.springdatajpa.transactions.app.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}