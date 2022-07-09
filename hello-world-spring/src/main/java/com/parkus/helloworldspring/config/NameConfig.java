package com.parkus.helloworldspring.config;

import java.util.List;

import com.parkus.helloworldspring.model.Name;
import com.parkus.helloworldspring.repository.NameRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameConfig {
    @Bean
    CommandLineRunner initDatabase(NameRepository nameRepository) {
        return args -> {
            Name a = new Name("Angular com Spring");
            Name b = new Name("Spring com Angular");
            Name c = new Name("Alexandre");
            

            nameRepository.saveAll(
                List.of(a, b, c)
            );
        };
    }
}
