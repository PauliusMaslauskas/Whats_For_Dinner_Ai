package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.VeggiesDTO;
import com.example.whats_for_dinner_ai.Entities.Veggies;
import com.example.whats_for_dinner_ai.Repositories.MealRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@NoArgsConstructor
public class VeggiesService {

    @Autowired
    private MealRepository mealRepository;

    public void saveVeggies(Collection<VeggiesDTO> veggiesDTO) {

        List<Veggies> veggies = new ArrayList<>();

        for (VeggiesDTO veggie : veggiesDTO) {

            Veggies allVeggies = new Veggies();
            allVeggies.setVeggieName(veggie.getVeggieName());

            veggies.add(allVeggies);
        }
        mealRepository.saveAll(veggies);
    }
}
