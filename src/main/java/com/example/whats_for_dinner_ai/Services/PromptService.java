package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.MealDTO;
import com.example.whats_for_dinner_ai.Entities.Prompt;
import com.example.whats_for_dinner_ai.Entities.Meal;
import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Repositories.MealRepository;
import com.example.whats_for_dinner_ai.Repositories.ProductRepository;
import com.example.whats_for_dinner_ai.Repositories.PromptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromptService {

    private final PromptRepository promptRepository;
    private final MealRepository mealRepository;
    private final ProductRepository productRepository;

    public String generatePrompt(MealDTO mealDTO) {
        Meal newMeal = createMealFromDTO(mealDTO);
        String promptText = generatePromptText(newMeal);

        savePrompt(promptText);
        saveMeal(newMeal);
        saveProducts(newMeal);
        return promptText;
    }

    private Meal createMealFromDTO(MealDTO mealDTO) {
        Meal newMeal = new Meal();
        newMeal.setMealType(mealDTO.getMealType());
        newMeal.setDiet(mealDTO.getDiet());
        newMeal.setProducts(mealDTO.getProducts());
        return newMeal;
    }

    private List<String> getProductsToList(Meal newMeal) {
        return newMeal.getProducts().stream()
                .map(Product::getProductName)
                .toList();
    }

    private String generatePromptText(Meal newMeal) {

        String promptText = "Hello chatGPT, I have these ingredients," + " " +
                "could you suggest a dinner menu with only the ingredients I have?" + " " +
                "I want it to be " + newMeal.getMealType().name() + " " +
                "and it should be " + newMeal.getDiet().name() + ". " +
                "I have these products: " + String.join(", ", getProductsToList(newMeal));

        return promptText;
    }


    private void savePrompt(String promptText) {
        Prompt prompt = new Prompt();
        prompt.setContent(promptText);
        promptRepository.save(prompt);
    }

    private void saveMeal(Meal newMeal) {
        mealRepository.save(newMeal);

    }

    private void saveProducts(Meal newMeal) {
        newMeal.getProducts().forEach(prd -> prd.setMeal(newMeal));
        productRepository.saveAll(newMeal.getProducts());
    }
}