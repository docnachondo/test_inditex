package com.example.hexapp.bootstrap;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.hexapp")
@EntityScan(basePackages = "com.example.hexapp.infrastructure.persistence.entity")
@EnableJpaRepositories(basePackages = "com.example.hexapp.infrastructure.persistence.adapter")
public class HexAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(HexAppApplication.class, args);
    }
}
