package com.greetingapp.greetingapp.service;

import com.greetingapp.greetingapp.entity.UserEntity;
import com.greetingapp.greetingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //UC_6-list all greeting messages
    //retrieves all greeting messages from the database
    public List<UserEntity> getAllMessages() {
        return repository.findAll();
    }

    //UC_5- to find a greeting message by ID
    public Optional<UserEntity> getMessageById(Long id) {
        return repository.findById(id);
    }

    // UC_7- method to update the greeting message in the repository
    public UserEntity updateMessage(Long id, String newMessage) {
        Optional<UserEntity> optionalUserEntity = repository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setMessage(newMessage);
            return repository.save(userEntity);
        }
        else {
            // Handle the case when the entity is not found
            return null;
        }
    }
    // UC_8- method to delete the greeting message from the repository
    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }

}