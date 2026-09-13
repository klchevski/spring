package com.example.demo.service;

import com.example.demo.exception.ProductNotFoundException;
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

        if (product == null) {
            throw new ProductNotFoundException("id product not found");
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

    @Override
    public Product findByMaxProduct() {
        Product product1 = null;
        int max = 0;
        for (Product product : productArrayList) {
            if (max < product.getPrice()) {
                product1 = product;
                max = product.getPrice();
            }
        }
        return product1;
    }

    @Override
    public Product findMinProduct() {
        Product product = productArrayList.get(0);
        int min = productArrayList.get(0).getPrice();
        for (Product product1 : productArrayList) {
            if (product1.getPrice() < min) {
                product = product1;
                min = product1.getPrice();
            }
        }
        return product;
    }

    @Override
    public List<Product> findDiapazon(int from, int to) {
        ArrayList<Product> productArrayList1 = new ArrayList<>();

        for (Product product : productArrayList) {
            if (product.getPrice() > from && product.getPrice() < to) {
                productArrayList1.add(product);
            }
        }
        return productArrayList1;
    }
}
