package com.nurfad.firstSpringExercise.service;

import com.nurfad.firstSpringExercise.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "Product 1", 0.1);
        products.add(product);
        Product product2 = new Product(2, "Product 2", 0.15);
        products.add(product2);
        return products;
    }
}
