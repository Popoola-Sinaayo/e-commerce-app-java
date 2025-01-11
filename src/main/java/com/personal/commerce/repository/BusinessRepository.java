package com.personal.commerce.repository;

import org.springframework.stereotype.Repository;

import com.personal.commerce.model.Business;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    
}
