package com.auth_service_nov2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @GetMapping("/welcome")
    public String getWelcome(){
        return "Welcome to our Hospital";
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello Patients";
    }
}
