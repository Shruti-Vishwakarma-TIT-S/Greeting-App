package com.greetingapp.greetingapp.controller;

import com.greetingapp.greetingapp.dto.UserDTO;
import com.greetingapp.greetingapp.entity.UserEntity;
import com.greetingapp.greetingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// Base path for all
@RequestMapping("/api")
public class UserController {
    //UC_1- Using different HTTP methods
    //GET
    // curl -X GET http://localhost:8080/api/greet
    @GetMapping("/greet")
    public String sayHello() {
        return "{\"message\" : \"Hello World.\"}";
    }

    //POST
    //curl -X POST http://localhost:8080/api/post
    @PostMapping("/post")
    public String sayHelloPost() {
        return "{\"message\" : \"Hello World. Greeting posted.\"}";
    }

    //PUT
    //curl -X PUT http://localhost:8080/api/put
    @PutMapping("/put")
    public String sayHelloPut() {
        return "{\"message\" : \"Hello World. Greeting updated.\"}";
    }

    //DELETE
    //curl -X DELETE http://localhost:8080/api/delete
    @DeleteMapping("/delete")
    public String sayHelloDelete() {
        return "{\"message\" : \"Greeting deleted.\"}";
    }

    //UC_2- to return a simple greeting message
    // curl -X GET http://localhost:8080/api/greet
    @Autowired
    //automatically injects the UserService bean into this controller
    private UserService userService;

    // Constructor-based Dependency Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    // curl -X GET http://localhost:8080/api/greeting
    public String sayHelloGet() {
        return UserService.getGreetingMessage();
    }

    // UC 3 --------------------------- starts here
    // curl -X POST http://localhost:8080/api/postGreet -H "Content-Type: application/json" -d "{\"firstName\":\"Jasmine\", \"lastName\":\"Vase\"}"
    @PostMapping("/postGreet")
    public String getGreetingMessage(@RequestBody UserDTO request) {
        return userService.greetingMessage(request.getFirstName(), request.getLastName());
    }

    //UC_4-save the greeting message in the repository
    //saves a new greeting message in the database
    @PostMapping
    public UserEntity saveGreeting(@RequestBody String message) {
        return userService.saveMessage(message);
    }

    //UC_6-list all greeting messages
    //retrieves all stored greeting messages
    @GetMapping
    public List<UserEntity> getAllGreetings() {
        return userService.getAllMessages();
    }

    //UC_5-endpoint to fetch a greeting message by ID
    @GetMapping("/{id}")
    public Optional<UserEntity> getGreetingById(@PathVariable Long id) {
        return userService.getMessageById(id);
    }

    // UC_7- to update a greeting message by ID
    @PutMapping("/greetings/{id}")
    public UserEntity updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return userService.updateMessage(id, newMessage);


    }
}