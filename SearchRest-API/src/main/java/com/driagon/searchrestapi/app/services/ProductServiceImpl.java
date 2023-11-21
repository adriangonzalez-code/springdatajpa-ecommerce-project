package com.driagon.searchrestapi.app.services;

import com.driagon.searchrestapi.app.models.Product;
import com.driagon.searchrestapi.app.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository repository;

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = this.repository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return this.repository.save(product);
    }
}