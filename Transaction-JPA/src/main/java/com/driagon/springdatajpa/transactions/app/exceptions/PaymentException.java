package com.driagon.springdatajpa.transactions.app.exceptions;

public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }
}