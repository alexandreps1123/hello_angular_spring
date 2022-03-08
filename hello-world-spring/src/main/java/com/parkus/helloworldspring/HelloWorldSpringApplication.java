package com.parkus.helloworldspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.parkus.helloworldspring.model.Names;
import com.parkus.helloworldspring.repository.NamesRepository;

@SpringBootApplication
public class HelloWorldSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringApplication.class, args);
	}

  	@Bean
	CommandLineRunner initDatabase(NamesRepository namesRepository) {
		return args -> {
			namesRepository.deleteAll();

			Names c = new Names();
			c.setName("Angular com Spring");

			namesRepository.save(c);
		};
  }
}
