package com.greetingapp.greetingapp.service;

import com.greetingapp.greetingapp.entity.UserEntity;
import com.greetingapp.greetingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //UC_2-
    public static String getGreetingMessage() {
        return "Hello Everyone.";
    }

    //UC_3-
    public String greetingMessage(String firstName, String lastName) {
        //both first name and last name are provided
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        }
        //only first name is provided
        else if (firstName != null) {
            return "Hello, " + firstName + "!";
        }
        //only last name is provided
        else if (lastName != null) {
            return "Hello, " + lastName + "!";
        }
        //return default greeting
        else {
            return "Hello World!";
        }
    }

    //UC_4-save the greeting message in the repository
    //injects UserRepository into this service
    @Autowired
    private UserRepository repository;
    //saves a new greeting message to the database
    public UserEntity saveMessage(String message) {
        return repository.save(new UserEntity(message));
    }
    //retrieves all greeting messages from the database
    public List<UserEntity> getAllMessages() {
        return repository.findAll();
    }
}