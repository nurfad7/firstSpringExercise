package com.nurfad.firstSpringExercise.service.impl;

import com.nurfad.firstSpringExercise.exceptions.DataNotFoundException;
import com.nurfad.firstSpringExercise.model.Product;
import com.nurfad.firstSpringExercise.repository.ProductRepository;
import com.nurfad.firstSpringExercise.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.findByName(product.getName()).ifPresent(existingProduct -> {
            throw new DataNotFoundException("Product with the name "
                    + product.getName() + " already exists");
        });
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new DataNotFoundException("Product with ID "
                    + product.getId() + " does not exist");
        }
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!productRepository.existsById(id)) {
            throw new DataNotFoundException("Product with ID " + id + " does not exist");
        }
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new DataNotFoundException("Product with ID " + id + " does not exist");
        }
        productRepository.softDeleteById(id);
    }
}
