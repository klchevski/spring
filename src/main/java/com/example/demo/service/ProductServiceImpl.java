package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public List<Product> allProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();

        allProducts.add(new Product(1, "Eraser", 3000));
        allProducts.add(new Product(2, "notebook", 35000));
        allProducts.add(new Product(3, "Pencil", 2000));

        return allProducts;
    }
}
