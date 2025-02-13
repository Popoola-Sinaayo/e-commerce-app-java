package com.personal.commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.commerce.dto.BusinessDto;
import com.personal.commerce.dto.BusinessLoginDto;
import com.personal.commerce.dto.BusinessLoginResponseDto;
import com.personal.commerce.dto.ResponseDto;
import com.personal.commerce.model.Business;
import com.personal.commerce.service.BusinessService;
import com.personal.commerce.utils.JwtClass;
import com.personal.commerce.utils.PasswordHasher;

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
        return new ResponseDto<String>(200, "success", "Test");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseDto<BusinessDto>> addBusiness(@Valid @RequestBody BusinessDto dto) {
        Business businessData = toBusiness(dto);
        businessService.addBusiness(businessData);
        // String token = new JwtClass().generateToken(businessData.getEmail(), businessData.getId());
        // System.out.println(token);
        return new ResponseEntity<ResponseDto<BusinessDto>>(new ResponseDto<BusinessDto>(200, "success", dto),
                HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<ResponseDto<String>> login(@Valid @RequestBody BusinessLoginDto dto) {
        Business business = businessService.findBusinessByEmail(dto.email());
        if (!PasswordHasher.verify(dto.password(), business.getPassword())) {
            return new ResponseEntity<ResponseDto<String>>(
                    new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "Invalid password", null),
                    HttpStatus.BAD_REQUEST);
        }
        String token = new JwtClass().generateToken(business.getEmail(), business.getId());
        return new ResponseEntity<ResponseDto<String>>(new ResponseDto<String>(200, "success", token), HttpStatus.OK);
    }
    
    @GetMapping("/me")
    public ResponseEntity<ResponseDto<BusinessDto>> me(@RequestHeader(value = "Authorization", required = false) String token) {
        System.out.println(token);
        Boolean isValid = new JwtClass().validateToken(token);
        if (!isValid) {
            return new ResponseEntity<ResponseDto<BusinessDto>>(
                    new ResponseDto<BusinessDto>(HttpStatus.UNAUTHORIZED.value(), "Unauthorized", null),
                    HttpStatus.UNAUTHORIZED);
        } else {
            String email = new JwtClass().extractEmail(token);
            Business business = businessService.findBusinessByEmail(email);
            BusinessDto businessDto = new BusinessDto(business.getName(), business.getAddress(), business.getEmail(),
                    business.getPassword());
            return new ResponseEntity<ResponseDto<BusinessDto>>(
                    new ResponseDto<BusinessDto>(200, "success", businessDto), HttpStatus.OK);
        }
    }

    private Business toBusiness(BusinessDto businessDto) {
        Business business = new Business();
        String hashedPassword = PasswordHasher.hash(businessDto.password());
        System.out.println(hashedPassword);
        business.setEmail(businessDto.email());
        business.setName(businessDto.name());
        business.setAddress(businessDto.address());
        business.setPassword(hashedPassword);
        return business;
    }


    
}
