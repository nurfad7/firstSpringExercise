package com.nurfad.firstSpringExercise.controller;

import com.nurfad.firstSpringExercise.model.FavoriteProduct;
import com.nurfad.firstSpringExercise.responses.Response;
import com.nurfad.firstSpringExercise.service.FavoriteProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoriteProductController {
    private final FavoriteProductService favoriteProductService;

    public FavoriteProductController(FavoriteProductService favoriteProductService) {
        this.favoriteProductService = favoriteProductService;
    }

    @GetMapping
    public ResponseEntity<Response<List<FavoriteProduct>>> getFavoriteProducts() {
        return Response.successfulResponse("All favorite products fetched",
                favoriteProductService.getFavoriteProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Response<Optional<FavoriteProduct>>> getFavoriteProductByProductId(@PathVariable Long productId) {
        return Response.successfulResponse("item with product ID "
                + productId + " was fetched",
                favoriteProductService.getFavoriteProductByProductId(productId));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<Response<FavoriteProduct>> favorite(@PathVariable Long productId) {
        FavoriteProduct favoriteProduct = favoriteProductService.favorite(productId);
        return Response.successfulResponse("Product was "
                + (favoriteProduct.isFavorite() ? "added to" : "removed from" )
                + " favorite", favoriteProduct);
    }
}
