package com.personal.commerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = Business.class)
    private Business business;
    @ManyToMany(targetEntity = Product.class)
    private List<Product> products;

    public Order() {
    }

    public Order(User user, Business business, List<Product> products) {
        this.user = user;
        this.business = business;
        this.products = products;
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Business getBusiness() {
        return this.business;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
