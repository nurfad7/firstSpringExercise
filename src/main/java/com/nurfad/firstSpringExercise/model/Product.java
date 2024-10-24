package com.nurfad.firstSpringExercise.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

@Data
@AllArgsConstructor
public class Product {
    private int Id;
    private String productName;
    private double price;
}
