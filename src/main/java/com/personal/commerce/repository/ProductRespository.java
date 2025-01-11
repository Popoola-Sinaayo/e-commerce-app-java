package com.personal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.commerce.model.Product;

public interface ProductRespository extends JpaRepository<Product, Long> {
    
}
