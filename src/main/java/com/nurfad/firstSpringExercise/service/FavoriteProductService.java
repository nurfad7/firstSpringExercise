package com.nurfad.firstSpringExercise.service;

import com.nurfad.firstSpringExercise.model.FavoriteProduct;

import java.util.List;
import java.util.Optional;

public interface FavoriteProductService {
    public List<FavoriteProduct> getFavoriteProducts();
    public Optional<FavoriteProduct> getFavoriteProductByProductId(Long id);
    public FavoriteProduct favorite(Long productId);
}
