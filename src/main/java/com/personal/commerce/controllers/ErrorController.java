package com.personal.commerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.commerce.dto.ResponseDto;

@RestController
@RequestMapping(path = "api/v1/error")
public class ErrorController {

    @GetMapping()
    public ResponseDto<String> error() {
        return new ResponseDto<String>(404, "Error", "Route not found");
    }
}
