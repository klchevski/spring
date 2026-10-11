package com.example.demo.service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.exception.ProductTotalException;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ArrayList<Product> productArrayList = new ArrayList<>();

    /**
     * Find products
     *
     * @return {@link List} of products
     */
    @Override
    public List<Product> allProducts() {
        return productArrayList;
    }

    /**
     * Save product
     *
     * @param product to List products
     */
    @Override
    public void save(Product product) {
        productArrayList.add(product);
    }

    /**
     * Find product by id
     *
     * @param id the id of product
     * @return found product
     */
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

    /**
     * Get total sum of products
     *
     * @return total balance
     */
    @Override
    public Integer summa() {
        int summa = 0;

        for (Product product : productArrayList) {
            summa += product.getPrice();
        }

        if (summa == 0) {
            throw new ProductTotalException("Total not found");
        }
        return summa;
    }

    /**
     * Find max product by balance
     *
     * @return the max product
     * @throws {@link ProductNotFoundException} when products not exists
     */
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
        if (product1 == null) {
            throw new ProductNotFoundException("Product not found");
        }
        return product1;
    }

    /**
     * Find min products by balance
     *
     * @return the min product
     */
    @Override
    public Product findMinProduct() {
        if (productArrayList.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
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

    /**
     * Find products by balance range
     *
     * @param from min balance
     * @param to   max balace
     * @return {@link List} of products
     */
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

    @Override
    public Integer getTotalBalanceRangeCount(int from, int to) {
        int count = 0;
        for (Product product : productArrayList) {
            if (product.getPrice() > from && product.getPrice() < to) {
                count++;
            }
        }
        return count;
    }
}
