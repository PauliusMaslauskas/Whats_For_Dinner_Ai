package com.example.whats_for_dinner_ai.Repositories;

import com.example.whats_for_dinner_ai.Entities.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetables, Integer> {


}
