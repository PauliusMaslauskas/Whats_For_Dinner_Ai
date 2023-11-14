package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.MealDTO;
import com.example.whats_for_dinner_ai.Entities.Prompt;
import com.example.whats_for_dinner_ai.Entities.Meal;
import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Entities.Response;
import com.example.whats_for_dinner_ai.Repositories.PromptRepository;
import com.example.whats_for_dinner_ai.Repositories.ResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromptService {

    private final PromptRepository promptRepository;
    private final ResponseRepository responseRepository;
    private final MealService mealService;

    public String generatePrompt(MealDTO mealDTO) {
        Meal newMeal = createMealFromDTO(mealDTO);
        String promptText = generatePromptText(newMeal);

        savePromptToDatabase(promptText);
        mealService.saveMealToDatabase(newMeal);
        mealService.saveProductsToDatabase(newMeal);
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
        return "Hello chatGPT, I have these ingredients," + " " +
                "could you suggest a dinner menu with only the ingredients I have?" + " " +
                "I want it to be " + newMeal.getMealType().name() + " " +
                "and it should be " + newMeal.getDiet().name() + ". " +
                "I have these products: " + String.join(", ", getProductsToList(newMeal));
    }

    private void savePromptToDatabase(String promptText) {
        Prompt prompt = new Prompt();
        prompt.setContent(promptText);
        promptRepository.save(prompt);
    }

    public void saveResponseToDatabase(String response){
        Response savedResponse = new Response();
        savedResponse.setResponse(response);
        responseRepository.save(savedResponse);
    }
}