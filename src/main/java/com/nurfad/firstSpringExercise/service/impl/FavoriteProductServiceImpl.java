package com.nurfad.firstSpringExercise.service.impl;

import com.nurfad.firstSpringExercise.model.FavoriteProduct;
import com.nurfad.firstSpringExercise.repository.FavoriteProductRepository;
import com.nurfad.firstSpringExercise.service.FavoriteProductService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Log
public class FavoriteProductServiceImpl implements FavoriteProductService {
    FavoriteProductRepository favoriteProductRepository;

    FavoriteProductServiceImpl(FavoriteProductRepository favoriteProductRepository) {
        this.favoriteProductRepository = favoriteProductRepository;
    }

    @Override
    public List<FavoriteProduct> getFavoriteProducts() {
        return favoriteProductRepository.findByIsFavoriteTrue();
    }

    @Override
    public Optional<FavoriteProduct> getFavoriteProductByProductId(Long productId) {
        return favoriteProductRepository.findByProductId(productId);
    }

    @Override
    public FavoriteProduct favorite(Long productId) {
        Optional<FavoriteProduct> favoriteProduct = favoriteProductRepository
                .findByProductId(productId);
        AtomicReference<FavoriteProduct> favoriteRef = new AtomicReference<>();
        favoriteProduct.ifPresentOrElse(existingFavorite -> {
            existingFavorite.setFavorite(!existingFavorite.isFavorite());
            favoriteRef.set(favoriteProductRepository.save(existingFavorite));
        }, () -> {
            FavoriteProduct newFavoriteProduct = new FavoriteProduct();
            newFavoriteProduct.setProductId(productId);
            newFavoriteProduct.setFavorite(true);
            favoriteRef.set(favoriteProductRepository.save(newFavoriteProduct));
        });
        return favoriteRef.get();
    }
}
