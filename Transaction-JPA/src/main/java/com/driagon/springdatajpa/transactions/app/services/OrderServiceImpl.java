package com.driagon.springdatajpa.transactions.app.services;

import com.driagon.springdatajpa.transactions.app.dto.OrderRequest;
import com.driagon.springdatajpa.transactions.app.dto.OrderResponse;
import com.driagon.springdatajpa.transactions.app.exceptions.PaymentException;
import com.driagon.springdatajpa.transactions.app.models.Order;
import com.driagon.springdatajpa.transactions.app.models.Payment;
import com.driagon.springdatajpa.transactions.app.repositories.IOrderRepository;
import com.driagon.springdatajpa.transactions.app.repositories.IPaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;

    private IPaymentRepository paymentRepository;

    public OrderServiceImpl(IOrderRepository orderRepository, IPaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest request) {

        Order order = request.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        this.orderRepository.save(order);

        Payment payment = request.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type does not support");
        }

        payment.setOrderId(order.getId());

        this.paymentRepository.save(payment);

        OrderResponse response = new OrderResponse();
        response.setOrderTrackingNumber(order.getOrderTrackingNumber());
        response.setStatus(order.getStatus());
        response.setMessage("SUCCESS");

        return response;
    }
}