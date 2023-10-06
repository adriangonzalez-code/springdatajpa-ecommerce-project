package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = this.productRepository.findByName("Product 1");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = this.productRepository.findById(10L).get();

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = this.productRepository.findByNameOrDescription("Product 1", "Product 1 Description");

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = this.productRepository.findByNameAndDescription("Product 1", "Product 1 Description");

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = this.productRepository.findDistinctByName("Product 1");

        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getName() = " + product.getName());
        System.out.println("product.getDescription() = " + product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = this.productRepository.findByPriceGreaterThan(new BigDecimal(100));

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = this.productRepository.findByPriceLessThan(new BigDecimal(200));

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = this.productRepository.findByNameContaining("Product 1");

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = this.productRepository.findByNameLike("Product 1");

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = this.productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }
}