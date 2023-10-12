package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod() {
        Product product = this.productRepository.findByNameOrDescriptionSQLIndexParam("Product 1", "Prodct 1 Description");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod() {
        Product product = this.productRepository.findByNameOrDescriptionSQLNamedParam("Product 1", "Product 1 Description");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
    }
}