package com.sarbo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test"));
		var ctx = app.run(args);

//		var ctx = SpringApplication.run(ExampleApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
//		System.out.println(ctx.getBeanDefinitionNames());
//		System.out.println(myFirstService.getJavaVersion());
//		System.out.println(myFirstService.getOsName());
//		System.out.println(myFirstService.readProp());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomProperty2());
		System.out.println(myFirstService.getCustomProperty3());
	}



}
