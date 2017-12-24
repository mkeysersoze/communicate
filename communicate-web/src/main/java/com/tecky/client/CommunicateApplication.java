package com.tecky.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.tecky" })
public class CommunicateApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CommunicateApplication.class, args);
	}
}
