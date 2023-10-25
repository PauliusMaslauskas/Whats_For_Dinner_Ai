package com.example.whats_for_dinner_ai.Repositories;

import com.example.whats_for_dinner_ai.Entities.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Integer> {
}
