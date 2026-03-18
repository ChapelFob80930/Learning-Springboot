package com.sarbo.example;

// Simple POJO class used as a Spring Bean
// Represents a basic service/component with some business logic
public class MyFirstClass {

    // Instance variable holding some value
    private String myVar;

    // Constructor used to initialize the object
    // Spring will call this when creating the bean
    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    // Business method
    // Returns a message using the value of myVar
    public String sayHello(){
        return "Hello from MyFirstClass ==> myVar = "+myVar;
    }

    // 🔑 KEY CONCEPTS:

    // POJO:
    // - Plain Java class with no special restrictions
    // - Becomes a Spring Bean when managed by Spring (@Bean, @Component, etc.)

    // Constructor Injection:
    // - myVar is passed via constructor
    // - Ensures the object is fully initialized at creation time

    // Spring Bean:
    // - When this class is returned from a @Bean method (in ApplicationConfig),
    //   Spring manages its lifecycle

    // ⚡ Note:
    // - No setters → value is fixed after creation (semi-immutable behavior)
    // - Good practice for safer and predictable objects

}
