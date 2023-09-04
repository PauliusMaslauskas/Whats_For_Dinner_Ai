package com.example.whats_for_dinner_ai.controllers;

import com.example.whats_for_dinner_ai.DTO.VegetablesDTO;
import com.example.whats_for_dinner_ai.Services.PromptService;
import com.example.whats_for_dinner_ai.Services.VegetablesService;
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
    private final VegetablesService vegetablesService;

    @PostMapping("/prompt")
    public ResponseEntity<VegetablesDTO> getPrompt(@RequestBody Collection<VegetablesDTO> vegetablesDTO){
        vegetablesService.manageVegetables(vegetablesDTO);
        return ResponseEntity.ok().build();
    }
}
