package com.authnov2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/welcome")
public class WelcomeController {

    @GetMapping("/hello")
    public String getMesage(){
        return "Hello";
    }

    @GetMapping("/hi")
    public String getHiMessage(){
        return "Hi";
    }
}
