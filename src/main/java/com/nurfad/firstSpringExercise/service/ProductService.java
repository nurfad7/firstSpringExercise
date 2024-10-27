package com.nurfad.firstSpringExercise.service;

import com.nurfad.firstSpringExercise.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getProducts();
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Optional<Product> getProductById(Long id);
    public void deleteProduct(Long id);
}
