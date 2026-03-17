package com.sarbo.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean("bean1")
	@Profile("dev")
//	@Qualifier("bean1")
	public MyFirstClass myFirstBean() {
		return new MyFirstClass("First Bean");
	}

	@Bean("bean2")
//	@Qualifier("bean2")
	@Profile("test")
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("Second Bean");
	}

	@Bean("bean3")
//	@Primary
	public MyFirstClass myThridBean() {
		return new MyFirstClass("Third Bean");
	}




}
