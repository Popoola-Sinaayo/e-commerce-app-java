package com.personal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.commerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
