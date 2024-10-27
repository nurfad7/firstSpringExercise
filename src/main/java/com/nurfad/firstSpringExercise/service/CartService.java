package com.nurfad.firstSpringExercise.service;

import com.nurfad.firstSpringExercise.model.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartService {
    public List<CartItem> getCart();
    public CartItem addToCart(CartItem cartItem);
    public CartItem updateCart(CartItem cartItem);
    public void removeFromCart(Long id);
}
