package com.personal.commerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(targetEntity = User.class)
    private Long user;
    @ManyToMany(targetEntity = Product.class)
    private List<Product> products;

    public Cart() {
    }

    public Cart(Long user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return this.id;
    }

    public Long getUser() {
        return this.user;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setUser(Long userId) {
        this.user = userId;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
