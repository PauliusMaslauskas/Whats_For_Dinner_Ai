package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.MealDTO;
import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Enums.ProductCategory;
import com.example.whats_for_dinner_ai.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> filterProducts(Collection<MealDTO> mealDTOS) {

        List<Product> products = new ArrayList<>();

        for (MealDTO product : mealDTOS){

            Product allProducts = new Product();
            allProducts.setName(product.getName());
            allProducts.setColor(product.getColor());
            allProducts.setProductCategory(ProductCategory.valueOf(product.getProductCategory()));
            products.add(allProducts);
        }

        productRepository.saveAll(products);

        return products;
    }

}
