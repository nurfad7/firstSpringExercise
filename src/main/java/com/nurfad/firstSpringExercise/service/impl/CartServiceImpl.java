package com.nurfad.firstSpringExercise.service.impl;

import com.nurfad.firstSpringExercise.exceptions.DataNotFoundException;
import com.nurfad.firstSpringExercise.model.CartItem;
import com.nurfad.firstSpringExercise.model.Product;
import com.nurfad.firstSpringExercise.repository.CartRepository;
import com.nurfad.firstSpringExercise.repository.ProductRepository;
import com.nurfad.firstSpringExercise.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    CartRepository cartRepository;
    ProductRepository productRepository;

    CartServiceImpl(CartRepository cartRepository,
                    ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<CartItem> getCart() {
        return cartRepository.findAll();
    }

    @Override
    public CartItem addToCart(CartItem cartItem) {
        if (cartRepository.existsByProductId(cartItem.getProductId())) {
            String productName = productRepository.findById(cartItem.getProductId())
                    .map(Product::getName)
                    .orElseThrow(() -> new DataNotFoundException("Product not found"));
            throw new DataNotFoundException("Product with the name " + productName + " already exists");
        }
        return cartRepository.save(cartItem);
    }

    @Override
    public CartItem updateCart(CartItem cartItem) {
        Optional<CartItem> cartItemFromTable = cartRepository.findByProductId(cartItem.getProductId());
        cartItemFromTable.orElseGet(() -> {
            String productName = productRepository.findById(cartItem.getProductId())
                    .map(Product::getName)
                    .orElseThrow(() -> new DataNotFoundException("Product not found"));
            throw new DataNotFoundException("Product with the name " + productName + " does not exist");
        });
        return cartRepository.save(cartItem);
    }

    @Override
    public void removeFromCart(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new DataNotFoundException("Cart item with item ID " + id + " does not exist");
        }
        cartRepository.deleteById(id);
    }
}
