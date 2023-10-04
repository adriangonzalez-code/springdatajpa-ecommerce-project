package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IProductRepositoryTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void saveMethod() {
        // Create product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Product 1 Description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // Save Product
        Product savedObject = this.productRepository.save(product);

        // Display Product Info
        System.out.println("savedObject.getId() = " + savedObject.getId());
        System.out.println("savedObject = " + savedObject);
    }

    @Test
    void updateUsingSaveMethod() {
        // Find or retrieve an entity by Id
        Long id = 1L;
        Product product = this.productRepository.findById(id).get();

        // Update entity information
        product.setName("Updated Product 1");
        product.setDescription("Updated product 1 description");

        // Save updated entity
        this.productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = this.productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {
        // Create product
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Product 2 Description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        // Create product
        Product product3 = new Product();
        product3.setName("Product 4");
        product3.setDescription("Product 4 Description");
        product3.setSku("100ABCDEF");
        product3.setPrice(new BigDecimal(400));
        product3.setActive(true);
        product3.setImageUrl("product4.png");

        List<Product> products = this.productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> products = this.productRepository.findAll();
        products.forEach(p -> {
            System.out.println("p.getName() = " + p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 2L;
        this.productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        // Find an entity by Id
        Long id = 1L;
        Product product = this.productRepository.findById(id).get();

        // Delete (entity)
        this.productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        // this.productRepository.deleteAll();
        Product product = this.productRepository.findById(7L).get();
        Product product1 = this.productRepository.findById(8L).get();

        this.productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void countMethod() {
        long count = this.productRepository.count();
        System.out.println("count = " + count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 10L;

        boolean result = this.productRepository.existsById(id);

        System.out.println("result = " + result);
    }
}