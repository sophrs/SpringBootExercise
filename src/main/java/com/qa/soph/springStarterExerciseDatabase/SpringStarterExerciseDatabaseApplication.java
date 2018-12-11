package com.qa.soph.springStarterExerciseDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringStarterExerciseDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarterExerciseDatabaseApplication.class, args);
	}
}
