package com.example.whats_for_dinner_ai.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MealDTO {

    private String mealType;

    private String productCategory;

    private String name;

    private String color;

    @Override
    public String toString() {
        return color + " " + name;
    }
}

