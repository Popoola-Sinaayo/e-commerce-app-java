package com.personal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.commerce.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
