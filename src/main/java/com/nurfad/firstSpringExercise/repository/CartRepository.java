package com.nurfad.firstSpringExercise.repository;

import com.nurfad.firstSpringExercise.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByProductId(Long productId);
    boolean existsByProductId(Long productId);
}
