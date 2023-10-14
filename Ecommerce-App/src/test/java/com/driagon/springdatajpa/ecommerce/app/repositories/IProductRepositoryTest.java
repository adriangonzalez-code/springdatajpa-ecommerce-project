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

        // Create product
        Product product5 = new Product();
        product5.setName("Product 5");
        product5.setDescription("Product 5 Description");
        product5.setSku("FI43HJF");
        product5.setPrice(new BigDecimal(500));
        product5.setActive(true);
        product5.setImageUrl("product5.png");

        // Create product
        Product product6 = new Product();
        product6.setName("Product 6");
        product6.setDescription("Product 6 Description");
        product6.setSku("FIHU34I");
        product6.setPrice(new BigDecimal(900));
        product6.setActive(true);
        product6.setImageUrl("product6.png");

        // Create product
        Product product7 = new Product();
        product7.setName("Product 7");
        product7.setDescription("Product 7 Description");
        product7.setSku("IE4BS4");
        product7.setPrice(new BigDecimal(1200));
        product7.setActive(true);
        product7.setImageUrl("product7.png");

        // Create product
        Product product8 = new Product();
        product8.setName("Product 8");
        product8.setDescription("Product 8 Description");
        product8.setSku("ON45U334R");
        product8.setPrice(new BigDecimal(800));
        product8.setActive(true);
        product8.setImageUrl("product8.png");

        // Create product
        Product product9 = new Product();
        product9.setName("Product 9");
        product9.setDescription("Product 9 Description");
        product9.setSku("16CEWRXDF");
        product9.setPrice(new BigDecimal(5160));
        product9.setActive(true);
        product9.setImageUrl("product9.png");

        // Create product
        Product product10 = new Product();
        product10.setName("Product 10");
        product10.setDescription("Product 10 Description");
        product10.setSku("16E5FSD5F");
        product10.setPrice(new BigDecimal(3200));
        product10.setActive(true);
        product10.setImageUrl("product10.png");

        // Create product
        Product product11 = new Product();
        product11.setName("Product 11");
        product11.setDescription("Product 11 Description");
        product11.setSku("DF5S6SS4");
        product11.setPrice(new BigDecimal(600));
        product11.setActive(true);
        product11.setImageUrl("product11.png");

        // Create product
        Product product12 = new Product();
        product12.setName("Product 12");
        product12.setDescription("Product 12 Description");
        product12.setSku("165DF1SD");
        product12.setPrice(new BigDecimal(700));
        product12.setActive(true);
        product12.setImageUrl("product12.png");

        // Create product
        Product product13 = new Product();
        product13.setName("Product 13");
        product13.setDescription("Product 13 Description");
        product13.setSku("DS68R4V1GDS");
        product13.setPrice(new BigDecimal(900));
        product13.setActive(true);
        product13.setImageUrl("product13.png");

        // Create product
        Product product14 = new Product();
        product14.setName("Product 14");
        product14.setDescription("Product 14 Description");
        product14.setSku("16S5D51F");
        product14.setPrice(new BigDecimal(165500));
        product14.setActive(true);
        product14.setImageUrl("product14.png");

        // Create product
        Product product15 = new Product();
        product15.setName("Product 15");
        product15.setDescription("Product 15 Description");
        product15.setSku("85SDF4DX");
        product15.setPrice(new BigDecimal(16520));
        product15.setActive(true);
        product15.setImageUrl("product15.png");

        // Create product
        Product product16 = new Product();
        product16.setName("Product 16");
        product16.setDescription("Product 16 Description");
        product16.setSku("18SDF4SD");
        product16.setPrice(new BigDecimal(8410));
        product16.setActive(true);
        product16.setImageUrl("product16.png");

        // Create product
        Product product17 = new Product();
        product17.setName("Product 17");
        product17.setDescription("Product 17 Description");
        product17.setSku("468SDFSD");
        product17.setPrice(new BigDecimal(5451));
        product17.setActive(true);
        product17.setImageUrl("product17.png");

        // Create product
        Product product18 = new Product();
        product18.setName("Product 18");
        product18.setDescription("Product 18 Description");
        product18.setSku("F68DG4DS");
        product18.setPrice(new BigDecimal(987454));
        product18.setActive(true);
        product18.setImageUrl("product18.png");

        // Create product
        Product product19 = new Product();
        product19.setName("Product 19");
        product19.setDescription("Product 19 Description");
        product19.setSku("R4F4G5DF");
        product19.setPrice(new BigDecimal(15845));
        product19.setActive(true);
        product19.setImageUrl("product19.png");

        // Create product
        Product product20 = new Product();
        product20.setName("Product 20");
        product20.setDescription("Product 20 Description");
        product20.setSku("68D4FSD");
        product20.setPrice(new BigDecimal(86544));
        product20.setActive(true);
        product20.setImageUrl("product20.png");

        List<Product> products = this.productRepository.saveAll(List.of(product2, product3, product5, product6, product7, product8, product9, product10, product11, product12, product13, product14, product15, product16, product17, product18, product19, product20));
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
        Product product = this.productRepository.findById(12L).get();
        Product product1 = this.productRepository.findById(13L).get();

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