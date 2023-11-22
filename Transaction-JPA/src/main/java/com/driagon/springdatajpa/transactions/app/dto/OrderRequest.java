package com.driagon.springdatajpa.transactions.app.dto;

import com.driagon.springdatajpa.transactions.app.models.Order;
import com.driagon.springdatajpa.transactions.app.models.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}