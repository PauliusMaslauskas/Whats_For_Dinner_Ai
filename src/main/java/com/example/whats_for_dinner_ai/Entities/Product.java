package com.example.whats_for_dinner_ai.Entities;

import com.example.whats_for_dinner_ai.Enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    private ProductCategory productCategory;

    private String name;

    private String color;

}
