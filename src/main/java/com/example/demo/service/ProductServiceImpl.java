package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ArrayList<Product> productArrayList = new ArrayList<>();

    @Override
    public List<Product> allProducts() {
        return productArrayList;
    }

    @Override
    public void save(Product product) {
        productArrayList.add(product);
    }

    @Override
    public Product findById(int id) {
        Product product = null;

        for (Product product1 : productArrayList) {
            if (product1.getId() == id) {
                product = product1;
                break;
            }
        }
        return product;
    }

    @Override
    public Integer summa() {
        int summa = 0;

        for (Product product : productArrayList) {
            summa += product.getPrice();
        }

        return summa;
    }


}
