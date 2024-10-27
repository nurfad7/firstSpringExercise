package com.nurfad.firstSpringExercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite_product")
public class FavoriteProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @NotNull
    @Column(name = "is_favorite", nullable = false)
    private boolean isFavorite = true;
}
