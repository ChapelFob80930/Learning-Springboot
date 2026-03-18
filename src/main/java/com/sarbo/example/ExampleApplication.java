package com.sarbo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;

// @SpringBootApplication is a convenience annotation that combines:
// - @Configuration (defines beans)
// - @EnableAutoConfiguration (auto-configures Spring based on dependencies)
// - @ComponentScan (scans this package and sub-packages for components)

@SpringBootApplication
public class ExampleApplication {

	// Entry point of the Spring Boot application

	// SpringApplication.run():
	// - Bootstraps the application
	// - Starts the embedded server (e.g., Tomcat)
	// - Creates and initializes the Spring Application Context
	// - Performs component scanning and dependency injection

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class);

	}



}
