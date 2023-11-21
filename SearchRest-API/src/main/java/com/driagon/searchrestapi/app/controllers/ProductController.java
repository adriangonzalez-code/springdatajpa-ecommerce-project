package com.driagon.searchrestapi.app.controllers;

import com.driagon.searchrestapi.app.models.Product;
import com.driagon.searchrestapi.app.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
        return ResponseEntity.ok(this.service.searchProducts(query));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return this.service.createProduct(product);
    }
}