package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.MealDTO;
import com.example.whats_for_dinner_ai.Entities.Prompt;
import com.example.whats_for_dinner_ai.Repositories.PromptRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class PromptService {

    @Autowired
    private final PromptRepository promptRepository;
    private final ProductService productService;

    public String generatePrompt(Collection<MealDTO> mealDTOList) {
        String promptText = createPromptText(productService.filterProducts(mealDTOList).toString());
        savePrompt(mealDTOList);
        saveProducts(mealDTOList);
        return promptText;
    }
    private String createPromptText(String products) {

        return "Hello chatGPT, I have these ingredients," +
                " could you suggest a dinner menu with only the ingrediants I have?" +
             // "I want it to be" MEALTYPE
                // "I have these vegetables"
                + "\n Vegetables: " + products;
    }

    private void savePrompt(Collection<MealDTO> mealDTOList) {
        Prompt prompt = new Prompt();
        prompt.setPrompt(mealDTOList.toString());
        promptRepository.save(prompt);
    }

    private void saveProducts(Collection<MealDTO> mealDTOList) {
        productService.filterProducts(mealDTOList);
    }

}