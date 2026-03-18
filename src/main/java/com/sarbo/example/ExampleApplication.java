package com.sarbo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;

// Marks this as the main Spring Boot application class
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// Creating a SpringApplication instance manually (instead of using shortcut run())
		var app = new SpringApplication(ExampleApplication.class);

		// Setting default properties for the application
		// Here → activating "test" profile by default
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test"));

		// Starting the application and getting the ApplicationContext
		// ApplicationContext = Spring container holding all beans
		var ctx = app.run(args);

		// Shortcut way (commented):
//		var ctx = SpringApplication.run(ExampleApplication.class, args);

		// 🔑 Fetching a bean (MyFirstService) from Spring container
		// Instead of manually creating object → Spring provides it (Dependency Injection)
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		// Calling methods from the bean
		System.out.println(myFirstService.tellAStory());

		// Debugging: prints all beans in the context
//		System.out.println(ctx.getBeanDefinitionNames());

		// Example of accessing environment/system properties via service
//		System.out.println(myFirstService.getJavaVersion());
//		System.out.println(myFirstService.getOsName());

		// Reading custom properties (likely from application.properties / YAML)
		// Demonstrates how Spring injects configuration values into beans
//		System.out.println(myFirstService.readProp());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomProperty2());
		System.out.println(myFirstService.getCustomProperty3());
	}



}
