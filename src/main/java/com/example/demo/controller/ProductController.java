package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product/findProduct")
    List<Product> findAll() {
        return productService.allProducts();
    }

    @PostMapping("products/save")
    void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("products/findById")
    Product findById(@RequestParam("id") int id) {
        return productService.findById(id);
    }

    @GetMapping("products/summaProducts")
    Integer summa() {
        return productService.summa();
    }

    @GetMapping("products/maxProduct")
    Product findByMaxProduct() {
        return productService.findByMaxProduct();
    }
}
