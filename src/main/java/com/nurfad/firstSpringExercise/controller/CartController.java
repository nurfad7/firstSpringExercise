package com.nurfad.firstSpringExercise.controller;

import com.nurfad.firstSpringExercise.model.CartItem;
import com.nurfad.firstSpringExercise.responses.Response;
import com.nurfad.firstSpringExercise.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Response<List<CartItem>>> getCart() {
        return Response.successfulResponse("All Item fetched", cartService.getCart());
    }

    @PostMapping
    public ResponseEntity<Response<CartItem>> addToCart(@Validated @RequestBody CartItem cartItem) {
        return Response.successfulResponse("Item was added to cart", cartService.addToCart(cartItem));
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Response<CartItem>> addToCart(@Validated @RequestBody CartItem cartItem, @PathVariable Long itemId) {
        cartItem.setId(itemId);
        return Response.successfulResponse("Cart item was updated", cartService.updateCart(cartItem));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Response<Objects>> addToCart(@PathVariable Long itemId) {
        cartService.removeFromCart(itemId);
        return Response.successfulResponse("Item was removed from cart");
    }
}
