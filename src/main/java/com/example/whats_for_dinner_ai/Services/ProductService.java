package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.Entities.Meal;
import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Repositories.MealRepository;
import com.example.whats_for_dinner_ai.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(int id){
        return productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product Not Found"));
    }
}
