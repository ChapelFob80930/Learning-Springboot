package com.sarbo.example.student;

public record StudentDTO(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
