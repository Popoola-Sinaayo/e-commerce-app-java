package com.personal.commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.commerce.dto.BusinessDto;
import com.personal.commerce.dto.ResponseDto;
import com.personal.commerce.model.Business;
import com.personal.commerce.service.BusinessService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping(path = "api/v1/business")
public class BusinessController {
    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/test")
    public ResponseDto<String> test() {
        return new ResponseDto<String>(200, "Success", "Test");
    }

    @PostMapping("/add")
    public ResponseDto<BusinessDto> addBusiness(@Valid @RequestBody BusinessDto dto) {
        Business businessData = toBusiness(dto);
        businessService.addBusiness(businessData);
        return new ResponseDto<BusinessDto>(200, "Success", dto);
    }

    private Business toBusiness(BusinessDto businessDto) {
        Business business = new Business();
        business.setEmail(businessDto.email());
        business.setName(businessDto.name());
        business.setAddress(businessDto.address());
        business.setPassword(businessDto.password());
        return business;
    }
    
}
