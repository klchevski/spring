package com.example.demo.service;

import com.example.demo.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> allProducts();

    void save(Product product);

    Product findById(int id);

    Integer summa();

    Product findByMaxProduct();
}
