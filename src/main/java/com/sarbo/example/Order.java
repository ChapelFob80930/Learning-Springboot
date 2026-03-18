package com.sarbo.example;

import com.fasterxml.jackson.annotation.JsonProperty;

// POJO representing an Order
// Used to map incoming JSON request data to a Java object
public class Order {

    // Maps JSON field "c-name" → customerName
    // Example JSON: { "c-name": "Sarbo" }
    @JsonProperty("c-name")
    private String customerName;

    // Maps JSON field "p-name" → productName
    @JsonProperty("p-name")
    private String productName;

    // Maps JSON field "q" → quantity
    @JsonProperty("q")
    private int quantity;

    // 🔑 SERIALIZATION & DESERIALIZATION:
    // - Deserialization → JSON → Java Object
    //   Spring (Jackson) uses setters to populate fields from incoming JSON
    //
    // - Serialization → Java Object → JSON
    //   Jackson uses getters to extract data when sending response

    // 🔑 WHY GETTERS & SETTERS ARE NEEDED:
    // - Fields are private → cannot be accessed directly outside the class
    // - Setters → used during deserialization (JSON → object)
    // - Getters → used during serialization (object → JSON)
    // - Without them → object may not be populated or returned correctly

    // Getter for customerName (used in serialization)
    public String getCustomerName() {
        return customerName;
    }

    // Getter for productName
    public String getProductName() {
        return productName;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for customerName (used by Jackson during deserialization)
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Setter for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString() method for readable output (useful for logging/debugging)
    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
