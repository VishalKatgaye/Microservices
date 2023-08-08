package com.sagitta.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.sagitta")
@EntityScan(basePackages = {"com.sagitta.domain"} )
@EnableJpaRepositories(basePackages = {"com.sagitta.dao"})
public class QuizappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
		System.out.println("*******This is question application*********");
	}
}