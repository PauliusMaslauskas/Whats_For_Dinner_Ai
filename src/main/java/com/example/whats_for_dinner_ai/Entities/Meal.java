package com.example.whats_for_dinner_ai.Entities;

import com.example.whats_for_dinner_ai.Enums.Diet;
import com.example.whats_for_dinner_ai.Enums.MealType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private MealType mealType;

    private Diet diet;

    @OneToMany(mappedBy = "meal")
    private List<Product> products;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Response response;

}
