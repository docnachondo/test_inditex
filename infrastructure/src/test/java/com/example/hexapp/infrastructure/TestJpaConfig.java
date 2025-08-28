package com.example.hexapp.infrastructure;

import com.example.hexapp.infrastructure.persistence.adapter.PriceRepositoryAdapter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan(basePackages = {
    "com.example.hexapp.infrastructure.persistence.entity",
    "com.example.hexapp.infrastructure.mappers"
})
@ComponentScan(basePackageClasses = PriceRepositoryAdapter.class)
@EnableJpaRepositories(basePackages = "com.example.hexapp.infrastructure.persistence.jpa")
public class TestJpaConfig {

    @Bean
    com.example.hexapp.infrastructure.mappers.PriceMapper priceMapper() {
        return org.mapstruct.factory.Mappers.getMapper(
                com.example.hexapp.infrastructure.mappers.PriceMapper.class
        );
    }

}
