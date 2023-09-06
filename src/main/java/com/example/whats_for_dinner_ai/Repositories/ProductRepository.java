package com.example.whats_for_dinner_ai.Repositories;

import com.example.whats_for_dinner_ai.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
