package com.personal.commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.commerce.model.Business;
import com.personal.commerce.repository.BusinessRepository;

@Service
public class BusinessService {
    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business addBusiness(Business business) {
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
                .orElseThrow(() -> new RuntimeException("Business by id " + id + " was not found"));
    }

    public Business findBusinessByEmail(String email) {
        Business business = businessRepository.findByEmail(email);
        if (business == null) {
            throw new RuntimeException("Business by email " + email + " was not found");
        }
        else {
            return business;
        }
    }
    
}
