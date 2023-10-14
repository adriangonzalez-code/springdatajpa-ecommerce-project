package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void paginationMethod() {
        int pageNo = 0;
        int pageSize = 5;

        // Create Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // findAll method and pass pageable instance
        Page<Product> page = this.productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(p -> {
            System.out.println("p = " + p);
        });

        // Total Pages
        int totalPages = page.getTotalPages();

        // Total elements
        long totalElements = page.getTotalElements();

        // Number of elements
        int numberOfElements = page.getNumberOfElements();

        // Size
        int size = page.getSize();

        // Last
        boolean isLast = page.isLast();

        // First
        boolean isFirst = page.isFirst();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("numberOfElements = " + numberOfElements);
        System.out.println("size = " + size);
        System.out.println("isLast = " + isLast);
        System.out.println("isFirst = " + isFirst);
    }

    @Test
    void sortingMethod() {
        String sortBy = "price";
        String sortDir = "asc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        List<Product> products = this.productRepository.findAll(sort);

        products.forEach(p -> {
            System.out.println("p = " + p);
        });
    }

    @Test
    void sortingByMultipleFieldsMethod() {
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupSort = sortByName.and(sortByDescription);

        List<Product> products = this.productRepository.findAll(groupSort);

        products.forEach(p -> {
            System.out.println("p = " + p);
        });
    }

    @Test
    void paginationAndSortingTogetherMethod() {
        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 1;
        int pageSize = 5;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = this.productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(p -> {
            System.out.println("p = " + p);
        });

        // Total Pages
        int totalPages = page.getTotalPages();

        // Total elements
        long totalElements = page.getTotalElements();

        // Number of elements
        int numberOfElements = page.getNumberOfElements();

        // Size
        int size = page.getSize();

        // Last
        boolean isLast = page.isLast();

        // First
        boolean isFirst = page.isFirst();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("numberOfElements = " + numberOfElements);
        System.out.println("size = " + size);
        System.out.println("isLast = " + isLast);
        System.out.println("isFirst = " + isFirst);
    }
}