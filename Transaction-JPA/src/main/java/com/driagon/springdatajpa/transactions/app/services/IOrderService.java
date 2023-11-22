package com.driagon.springdatajpa.transactions.app.services;

import com.driagon.springdatajpa.transactions.app.dto.OrderRequest;
import com.driagon.springdatajpa.transactions.app.dto.OrderResponse;

public interface IOrderService {

    OrderResponse placeOrder(OrderRequest request);
}