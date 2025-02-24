package com.greetingapp.greetingapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

    //UC_4-
    @Id
    //auto-generates unique ID values
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    //default constructor
    public UserEntity() {}
    //parameterized constructor
    public UserEntity(String message) {
        this.message = message;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}