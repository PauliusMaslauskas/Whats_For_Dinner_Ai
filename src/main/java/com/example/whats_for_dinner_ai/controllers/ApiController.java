package com.example.whats_for_dinner_ai.controllers;

import com.example.whats_for_dinner_ai.DTO.VeggiesDTO;
import com.example.whats_for_dinner_ai.Services.VeggiesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@AllArgsConstructor
public class ApiController {

    @Autowired
    private final VeggiesService veggiesService;


    @PostMapping("/prompt")
    public ResponseEntity<VeggiesDTO> getPrompt(@RequestBody Collection<VeggiesDTO> veggiesDTO){
        veggiesService.saveVeggies(veggiesDTO);
        return ResponseEntity.ok().build();
    }
}
