package com.personal.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.commerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
