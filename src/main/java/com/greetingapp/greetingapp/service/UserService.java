package com.greetingapp.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    //UC_2-
    public static String getGreetingMessage() {
        return "Hello Everyone.";
    }
}