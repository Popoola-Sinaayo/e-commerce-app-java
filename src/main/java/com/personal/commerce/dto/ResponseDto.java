package com.personal.commerce.dto;

public record ResponseDto<T> (  Integer statusCode,
     String message,
    T data) {
}
