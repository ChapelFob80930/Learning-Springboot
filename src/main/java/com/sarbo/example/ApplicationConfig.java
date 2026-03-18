package com.sarbo.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

// Marks this class as a configuration class
// Used to define beans manually (instead of component scanning)
@Configuration
public class ApplicationConfig {

	// Defines a bean named "bean1"
	// This bean will ONLY be created when "dev" profile is active
    @Bean("bean1")
	@Profile("dev")
//	@Qualifier("bean1")
	public MyFirstClass myFirstBean() {
		return new MyFirstClass("First Bean");
	}

	// Defines a bean named "bean2"
	// Active only when "test" profile is enabled
	@Bean("bean2")
//	@Qualifier("bean2")
	@Profile("test")
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("Second Bean");
	}

	// Defines a bean named "bean3"
	// No profile → always created regardless of environment
	@Bean("bean3")
//	@Primary
	public MyFirstClass myThridBean() {
		return new MyFirstClass("Third Bean");
	}


	// 🔑 KEY CONCEPTS:

	// @Bean:
	// - Tells Spring to create and manage this object as a bean
	// - The returned object is stored in ApplicationContext

	// @Profile:
	// - Controls which beans are loaded based on environment
	// - Example: dev, test, prod
	// - Helps switch configurations easily

	// Bean Naming:
	// - @Bean("bean1") → explicit name
	// - Default name = method name (if not specified)

	// ⚠️ Multiple Beans of Same Type (MyFirstClass):
	// - Spring will get confused if you try to inject without specifying which one

	// Solution options:

	// 1. @Primary (default bean if multiple exist)
	// 2. @Qualifier("beanName") (explicit selection)

	// Example:
	// @Primary → marks one bean as default
	// @Qualifier("bean2") → tells Spring exactly which bean to inject

	// 🔑 WHY USE NAME IN @Bean INSTEAD OF ONLY @Qualifier?

	// @Bean("beanName"):
	// - Defines the identity of the bean inside Spring container
	// - This is how Spring registers and stores the bean
	// - Required if you want a custom or clear name

	// @Qualifier("beanName"):
	// - Used at injection time to SELECT which bean to use
	// - Does NOT create or name the bean itself

	// 🧠 Key Difference:
	// - @Bean("name") → "what this bean is called"
	// - @Qualifier("name") → "which bean I want"

	// ⚡ Important:
	// You cannot use @Qualifier without a bean name existing
	// → Qualifier depends on bean naming

	// 🔥 Best Practice:
	// - Use @Bean("name") for clarity and control
	// - Use @Qualifier when multiple beans of same type exist

	// 🧠 Example Flow:
	// 1. Spring creates bean → name = "bean2"
	// 2. Later injection → @Qualifier("bean2") tells Spring to pick it

}
