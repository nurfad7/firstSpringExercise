package com.nurfad.firstSpringExercise.repository;

import com.nurfad.firstSpringExercise.model.FavoriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Long> {
    Optional<FavoriteProduct> findByProductId(Long productId);
    List<FavoriteProduct> findByIsFavoriteTrue();
}
