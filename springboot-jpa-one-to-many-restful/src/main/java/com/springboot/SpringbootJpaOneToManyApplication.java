package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootJpaOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaOneToManyApplication.class, args);
	}

}
