package com.example.whats_for_dinner_ai.Entities.Gpt;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ChatRequest {

    private String model;

    private List<Message> messages;

    private int n = 1;

    private double temperature;

    public ChatRequest(String model, String content) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", content));
    }

}
