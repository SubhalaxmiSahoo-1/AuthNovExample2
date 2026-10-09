package com.ms1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @GetMapping("/welcome")
    public String getMessageWelcome(){
        return "Welcome";
    }
}
