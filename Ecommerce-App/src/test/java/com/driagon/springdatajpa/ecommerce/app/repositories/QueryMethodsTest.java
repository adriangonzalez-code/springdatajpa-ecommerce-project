package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Test
    void findByDateCreatedBetweenMethod() {
        // Start Date
        LocalDateTime startDate = LocalDateTime.of(2023, 10, 3, 22, 23, 9);

        // End Date
        LocalDateTime endDate = LocalDateTime.of(2023, 10, 3, 22, 29, 26);

        List<Product> products = this.productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findByNameInMethod() {
        List<Product> products = this.productRepository.findByNameIn(List.of("Product 1", "Product 2", "Product 4"));

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = this.productRepository.findFirst2ByOrderByNameAsc();

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void findTop3ByOrderByPriceDescMethod() {
        List<Product> products = this.productRepository.findTop3ByOrderByPriceDesc();

        products.forEach(p -> {
            System.out.println("p.getId() = " + p.getId());
            System.out.println("p.getName() = " + p.getName());
        });
    }
}