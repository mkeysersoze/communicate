package com.tecky.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tecky.communicate.entity.Expression;
import com.tecky.communicate.repository.ExpressionRepository;

@SpringBootApplication
@Configuration
// When Spring Data finds it, it creates an implementation of all repositories
@EnableJpaRepositories(basePackages = "com.tecky", repositoryImplementationPostfix = "Impl")
@ComponentScan(basePackages = { "com.tecky" })
public class BootstrapApplication {

	private static final Logger log = LoggerFactory.getLogger(BootstrapApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);

	}

	// désactivation en faveur du projet web
//	@Bean
	public CommandLineRunner demo(ExpressionRepository expressionRepository) {
		return (args) -> {
			// save an expression
			Expression expression = new Expression();
			expression.setText("Débrouillard");
			expressionRepository.save(expression);

			// fetch all expressions
			log.info("Expressions found with findAll():");
			log.info("-------------------------------");
			for (Expression currentExpression : expressionRepository.findAll()) {
				log.info(currentExpression.toString());
			}

		};
	}

}
