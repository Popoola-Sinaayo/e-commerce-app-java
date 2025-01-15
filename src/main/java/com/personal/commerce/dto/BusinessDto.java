package com.personal.commerce.dto;

import jakarta.validation.constraints.NotBlank;

public record BusinessDto(

        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Address is required")
        String address,
            
    @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Password is required")
    String password) {
    
}
