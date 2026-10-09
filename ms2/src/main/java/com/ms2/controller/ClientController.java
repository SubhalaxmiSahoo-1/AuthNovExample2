package com.ms2.controller;

import com.ms2.client.WebClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/call")
public class ClientController {

    private WebClient webClient;

    public ClientController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("msg")
    public String getMsg(){
        return webClient.getMessageWelcome();
    }
}
