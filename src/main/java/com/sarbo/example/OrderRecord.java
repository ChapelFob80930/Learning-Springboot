package com.sarbo.example;

// Record representing an Order (immutable data carrier)
// Used for mapping JSON request/response data in a concise way
public record OrderRecord(
        // Fields (called components in records)
        String customerName,
        String productName,
        int quantity
) {
    // 🔑 RECORD BASICS:
    // - Automatically generates:
    //   • constructor
    //   • getters (customerName(), productName(), quantity())
    //   • toString(), equals(), hashCode()
    // - Fields are final → immutable (cannot be changed after creation)

    // 🔑 SERIALIZATION & DESERIALIZATION:
    // - Deserialization (JSON → Object):
    //   Jackson uses the generated constructor to create the object
    //
    // - Serialization (Object → JSON):
    //   Jackson uses the generated getter methods

    // 🔑 WHY NO GETTERS/SETTERS NEEDED:
    // - Getters are auto-generated → customerName(), etc.
    // - No setters → because records are immutable by design
    // - Data is set only once via constructor

    // 🔥 ADVANTAGE OVER POJO:
    // - No boilerplate (no manual getters/setters)
    // - Safer (immutable → prevents accidental changes)
}
