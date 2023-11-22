package com.driagon.springdatajpa.transactions.app.controllers;

import com.driagon.springdatajpa.transactions.app.dto.OrderRequest;
import com.driagon.springdatajpa.transactions.app.dto.OrderResponse;
import com.driagon.springdatajpa.transactions.app.services.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private IOrderService service;

    public OrderController(IOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(this.service.placeOrder(request));
    }
}