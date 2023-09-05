package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.VegetablesDTO;
import com.example.whats_for_dinner_ai.Entities.Vegetables;
import com.example.whats_for_dinner_ai.Repositories.VegetableRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class VegetablesService {

    @Autowired
    private VegetableRepository vegetableRepository;
    private PromptService promptService;


    public void manageVegetables(Collection<VegetablesDTO> vegetablesDTO){
        StringBuilder sbVegetables = new StringBuilder();

        for(VegetablesDTO vegetable : vegetablesDTO){
            sbVegetables.append(vegetable).append(", ");
        }

        if (!vegetablesDTO.isEmpty()){
            sbVegetables.setLength(sbVegetables.length() - 2);
        }
        String vegetables = sbVegetables.toString();
        promptService.generatePrompt(vegetables);
        saveVeggies(vegetablesDTO);
    }

    public void saveVeggies(Collection<VegetablesDTO> vegetablesDTO) {

        List<Vegetables> veggies = new ArrayList<>();

        for (VegetablesDTO veggie : vegetablesDTO) {

            Vegetables allVeggies = new Vegetables();
            allVeggies.setName(veggie.getName());
            allVeggies.setColor(veggie.getColor());

            veggies.add(allVeggies);
        }
        vegetableRepository.saveAll(veggies);
    }

    public Vegetables findVegetablesById(int id){
        return vegetableRepository.findById(id).orElseThrow(() -> new NullPointerException("Vegetables Not Found"));
    }
}
