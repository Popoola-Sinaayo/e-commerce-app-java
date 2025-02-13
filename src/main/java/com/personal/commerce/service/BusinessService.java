package com.personal.commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.commerce.model.Business;
import com.personal.commerce.repository.BusinessRepository;
import com.personal.commerce.utils.ResourceBadRequestException;

@Service
public class BusinessService {
    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business addBusiness(Business business) {
        Optional<Business> businessOptional = Optional.ofNullable(businessRepository.findByEmail(business.getEmail()));
        if (businessOptional.isPresent()) {
            throw new ResourceBadRequestException("Business by email " + business.getEmail() + " already exists");
        }
        return businessRepository.save(business);
    }

    public Business updateBusiness(Business business) {
        return businessRepository.save(business);
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }

    public Business findBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new ResourceBadRequestException("Business by id " + id + " was not found"));
    }

    public Business findBusinessByEmail(String email) {
        Business business = businessRepository.findByEmail(email);
        if (business == null) {
            throw new ResourceBadRequestException("Business by email " + email + " was not found");
        }
        else {
            return business;
        }
    }
    
}
