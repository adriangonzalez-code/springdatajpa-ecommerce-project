package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Address;
import com.driagon.springdatajpa.ecommerce.app.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private IOrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Pune");
        address.setStreet("Kothrud");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setZipCode("411047");

        order.setBillingAddress(address);

        this.orderRepository.save(order);
    }

    @Test
    void updateOrderMethod() {
        Order order = this.orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("411087");

        this.orderRepository.save(order);
    }

    @Test
    void deleteOrderMethod() {
        this.orderRepository.deleteById(1L);
    }

    @Test
    void getOrderMethod() {
        Order order = this.orderRepository.findById(2L).get();
        System.out.println(order);
    }
}