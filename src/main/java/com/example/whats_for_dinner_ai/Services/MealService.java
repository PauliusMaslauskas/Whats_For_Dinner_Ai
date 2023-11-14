package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.Entities.Meal;
import com.example.whats_for_dinner_ai.Repositories.MealRepository;
import com.example.whats_for_dinner_ai.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final ProductRepository productRepository;

    protected void saveMealToDatabase(Meal newMeal) {
        mealRepository.save(newMeal);
    }

    protected void saveProductsToDatabase(Meal newMeal) {
        newMeal.getProducts().forEach(prd -> prd.setMeal(newMeal));
        productRepository.saveAll(newMeal.getProducts());
    }
}
