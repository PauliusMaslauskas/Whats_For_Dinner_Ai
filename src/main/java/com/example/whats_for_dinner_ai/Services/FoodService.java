package com.example.whats_for_dinner_ai.Services;

import com.example.whats_for_dinner_ai.DTO.ProductDTO;
import com.example.whats_for_dinner_ai.Entities.Product;
import com.example.whats_for_dinner_ai.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProducts(Collection<ProductDTO> productDTO) {

        List<Product> products = new ArrayList<>();

        for (ProductDTO product : productDTO) {

            Product allProducts = new Product();
            allProducts.setName(product.getName());
            allProducts.setColor(product.getColor());

            products.add(allProducts);
        }
        productRepository.saveAll(products);
    }

}
