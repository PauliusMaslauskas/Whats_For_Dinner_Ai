package com.example.whats_for_dinner_ai.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 2555)
    private String response;

    @OneToOne
    @JoinColumn(name = "id")
    Meal meal;
}
