package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod() {
        Product product = this.productRepository.findByNameOrDescriptionJPQLIndexParam("Product 1", "Product 1 Description");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod() {
        Product product = this.productRepository.findByNameOrDescriptionJPQLNamedParam("Product 1", "Product 1 Description");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
    }
}