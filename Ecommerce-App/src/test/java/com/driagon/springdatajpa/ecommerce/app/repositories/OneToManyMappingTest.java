package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Address;
import com.driagon.springdatajpa.ecommerce.app.models.Order;
import com.driagon.springdatajpa.ecommerce.app.models.OrderItem;
import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IProductRepository productRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("SD8F74S");
        order.setStatus("In Progress");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(this.productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("imgUrl1.png");
        order.getOrderItems().add(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(this.productRepository.findById(2L).get());
        orderItem2.setQuantity(1);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(1)));
        orderItem2.setImageUrl("imgUrl2.png");
        order.getOrderItems().add(orderItem2);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setProduct(this.productRepository.findById(3L).get());
        orderItem3.setQuantity(3);
        orderItem3.setPrice(orderItem3.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem3.setImageUrl("imgUrl3.png");
        order.getOrderItems().add(orderItem3);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

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
    void fetchOrderMethod() {
        Order order = this.orderRepository.findById(1L).get();

        System.out.println(order.getStatus());
        System.out.println(order);
        for(OrderItem item : order.getOrderItems()) {
            System.out.println(item.getProduct().getName());
        }
    }

    @Test
    void deleteOrderMethod() {
        this.orderRepository.deleteById(1L);
    }
}