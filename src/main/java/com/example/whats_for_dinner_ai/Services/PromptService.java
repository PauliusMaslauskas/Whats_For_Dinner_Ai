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
    private final MealService mealService;
    private final ResponseRepository responseRepository;

    public String generatePrompt(MealDTO mealDTO) {
        Meal newMeal = createMealFromDTO(mealDTO);
        String promptText = generatePromptText(newMeal);

        savePrompt(promptText);
        mealService.saveMeal(newMeal);
        mealService.saveProducts(newMeal);
        return promptText;
    }

    private Meal createMealFromDTO(MealDTO mealDTO) {

        mealValidation(mealDTO);

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

    private void savePrompt(String promptText) {
        Prompt prompt = new Prompt();
        prompt.setContent(promptText);
        promptRepository.save(prompt);
    }
    public void saveResponse(String response){
        Response savedResponse = new Response();
        savedResponse.setResponse(response);
        responseRepository.save(savedResponse);
    }

    private void mealValidation(MealDTO mealDTO) {

        if (mealDTO.getProducts().isEmpty()) {
            throw new NullPointerException("No Products Provided");
        }
        if (mealDTO.getMealType() == null){
            throw new NullPointerException("No Meal Type Provided");
        }
        if (mealDTO.getDiet() == null){
            throw new NullPointerException("No Meal Diet Provided");
        }
    }
}