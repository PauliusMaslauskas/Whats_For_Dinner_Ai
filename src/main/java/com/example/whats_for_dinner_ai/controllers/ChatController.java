package com.example.whats_for_dinner_ai.controllers;

import com.example.whats_for_dinner_ai.DTO.MealDTO;
import com.example.whats_for_dinner_ai.Entities.ChatRequest;
import com.example.whats_for_dinner_ai.Entities.ChatResponse;
import com.example.whats_for_dinner_ai.Services.PromptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class ChatController {

    @Qualifier("weavyAiRestTemplate")
    private final RestTemplate restTemplate;

    private final PromptService promptService;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-3.5-turbo";

    @GetMapping("/chat")
    public String chat(@RequestBody Collection<MealDTO> mealDTOS) {

        ChatRequest request = new ChatRequest(MODEL, promptService.generatePrompt(mealDTOS));
        ChatResponse response = restTemplate.postForObject(API_URL, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        return response.getChoices().get(0).getMessage().getContent();
    }
}