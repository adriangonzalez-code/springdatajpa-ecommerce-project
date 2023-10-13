package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void namedJPQLQueryMethod() {
        Product product = this.productRepository.findByPrice(new BigDecimal(100));

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void namedJPQLQueriesMethod() {
        List<Product> products = this.productRepository.findAllOrderByNameDesc();
        
        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
            System.out.println("p.getDescription() = " + p.getDescription());
        });

        Product product = this.productRepository.findByPrice(new BigDecimal(200));

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void namedNativeSQLQueryMethod() {
        Product product = this.productRepository.findByDescription("Product 1 Description");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void namedNativeSQLQueriesMethod() {
        Product product = this.productRepository.findByDescription("Product 2 Description");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());

        List<Product> products = this.productRepository.findAllOrderByNameASC();

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
            System.out.println("p.getDescription() = " + p.getDescription());
        });
    }
}