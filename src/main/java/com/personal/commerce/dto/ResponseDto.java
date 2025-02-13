package com.personal.commerce.dto;

import java.util.Optional;

public record ResponseDto<T> (  Integer statusCode,
     String message,
    T data) {
}
