package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import com.driagon.springdatajpa.ecommerce.app.models.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
class IProductCategoryRepositoryTest {

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategoryMethod() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Books");
        productCategory.setCategoryDescription("Books description");

        Product product1 = new Product();
        product1.setName("Core Java");
        product1.setPrice(new BigDecimal(100));
        product1.setImageUrl("image1.png");
        product1.setSku("ABCD");
        product1.setActive(true);
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setPrice(new BigDecimal(2000));
        product2.setImageUrl("image2.png");
        product2.setSku("ABCDEF");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        this.productCategoryRepository.save(productCategory);
    }

    @Test
    @Transactional
    void fetchProductCategoryMethod() {
        ProductCategory category = this.productCategoryRepository.findById(1L).get();
        System.out.println(category.getProducts());
    }
}