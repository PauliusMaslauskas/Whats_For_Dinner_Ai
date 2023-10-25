package com.example.whats_for_dinner_ai.Templates;

import lombok.Value;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeavyAiRestTemplateConfig {

    private static final String openaiApiKey = "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";

    @Bean
    @Qualifier("weavyAiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
