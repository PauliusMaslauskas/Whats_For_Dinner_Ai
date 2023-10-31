package com.example.whats_for_dinner_ai.DTO;

import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Enums.Diet;
import com.example.whats_for_dinner_ai.Enums.MealType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MealDTO {

    private MealType mealType;

    private Diet diet;

    private List<Product> products;
}

