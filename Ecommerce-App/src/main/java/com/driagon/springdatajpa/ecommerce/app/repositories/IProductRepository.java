package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {


    Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
}