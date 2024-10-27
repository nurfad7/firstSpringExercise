package com.nurfad.firstSpringExercise.controller;

import com.nurfad.firstSpringExercise.model.Product;
import com.nurfad.firstSpringExercise.responses.Response;
import com.nurfad.firstSpringExercise.service.ProductService;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Product>>> getProducts() {
        return Response.successfulResponse("All products fetched",
                productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Response<Product>> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return Response.successfulResponse(
                HttpStatus.CREATED.value(),
                "Product(s) was created",
                productService.updateProduct(savedProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Product>> updateProduct(@Valid @RequestBody Product product,
                                                           @PathVariable Long id) {
        product.setId(id);
        return Response.successfulResponse(
                HttpStatus.CREATED.value(),
                "Product(s) was created",
                productService.updateProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Product>>> getProductById(@PathVariable Long id) {
        return Response.successfulResponse("All products fetched",
                productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Optional<Product>>> deleteProduct(@PathVariable Long id) {
        return Response.successfulResponse("All products fetched",
                productService.getProductById(id));
    }
}
