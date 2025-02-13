package com.personal.commerce.dto;

import jakarta.validation.constraints.NotBlank;

public record BusinessLoginDto(
    @NotBlank(message = "Email is required")
    String email,
    @NotBlank(message = "Password is required")
    String password
) {
    
}
