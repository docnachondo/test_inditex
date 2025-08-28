package com.example.hexapp.infrastructure.config;

import com.example.hexapp.domain.repository.PriceRepository;
import com.example.hexapp.domain.usecase.PriceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PriceUseCase priceUseCase(PriceRepository repo) {
        return new PriceUseCase(repo);
    }
}
