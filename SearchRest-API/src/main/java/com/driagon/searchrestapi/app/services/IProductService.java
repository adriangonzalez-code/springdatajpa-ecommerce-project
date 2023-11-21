package com.driagon.searchrestapi.app.services;

import com.driagon.searchrestapi.app.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}