package com.example.whats_for_dinner_ai;

import com.example.whats_for_dinner_ai.DTO.MealDTO;
import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Enums.Diet;
import com.example.whats_for_dinner_ai.Enums.MealType;
import com.example.whats_for_dinner_ai.Repositories.PromptRepository;
import com.example.whats_for_dinner_ai.Repositories.ResponseRepository;
import com.example.whats_for_dinner_ai.Services.MealService;
import com.example.whats_for_dinner_ai.Services.PromptService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

class WhatsForDinnerAiApplicationTests {

    @Mock
    private PromptService promptService;
    private PromptRepository promptRepository;
    private MealService mealService;
    private ResponseRepository responseRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        promptService = new PromptService(promptRepository, mealService, responseRepository);
    }

    @Test
    public void givenEmptyProducts_whenGeneratePrompt_ThenReturnsNullPointerException() {

        MealDTO mealDTO = generateMealDto(
                Collections.emptyList(),
                MealType.BEVERAGE,
                Diet.VEGETERIAN
        );

        Assertions.assertThrows(NullPointerException.class,
                () -> promptService.generatePrompt(mealDTO), "No Products Provided");
    }

    private MealDTO generateMealDto(List<Product> products, MealType mealType, Diet diet) {
        MealDTO testMeal = new MealDTO();
        testMeal.setProducts(products);
        testMeal.setMealType(mealType);
        testMeal.setDiet(diet);
        return testMeal;
    }

}

