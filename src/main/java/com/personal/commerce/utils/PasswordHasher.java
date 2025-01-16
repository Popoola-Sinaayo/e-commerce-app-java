package com.personal.commerce.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordHasher {
    public static String hash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
    
    public static boolean verify(String password, String hash) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, hash);
    }
}
