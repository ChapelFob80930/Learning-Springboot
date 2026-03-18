package com.sarbo.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// Marks this class as a REST controller
// Combines @Controller + @ResponseBody (returns data directly as HTTP response)
@RestController
public class FirstController {

    // Handles GET requests to /hello
    // Simple endpoint returning a static string
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello from my first controller";
    }

    // Example of setting custom HTTP status (currently commented out)
    // @ResponseStatus(HttpStatus.ACCEPTED) → returns 202 instead of 200
//    @GetMapping("/hello-2")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sayHello2()
//    {
//        return "Hello 2 from my first controller";
//    }

    // Handles POST request to /post
    // Accepts raw string from request body
    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request Accepted and message is : " + message;
    }

    // Handles POST request to /post-order
    // Converts JSON body into Order object (POJO)

    // POJO (Plain Old Java Object):
    // - A simple Java class with fields, getters/setters, and no special restrictions
    // - Used to represent data (like request/response objects)

    // Difference from Spring Bean:
    // - POJO → just a normal Java object (no Spring involvement)
    // - Spring Bean → a POJO managed by Spring (created, injected, lifecycle handled by Spring container)
    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ) {
        return "Request Accepted and message is : " + order.toString();
    }

    // Handles POST request to /post-order-record
    // Converts JSON into a Java Record (immutable data structure)
    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Request Accepted and message is : " + order.toString();
    }

    // Example of Path Variable (currently commented out)
    // URL example: /hello/sarbo
    // Extracts 'sarbo' into userName
    //@GetMapping("/hello/{user-name}")
    //@GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    )
    {
        return "my value = " + userName;
    }

    // Handles GET request with query parameters
    // Example: /hello?user-name=Sarbo&user-lastname=Biswas
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastName
    )
    {
        return "my value = " + userName + " " + userLastName;
    }

}
