package com.ms2.controller;

import com.ms2.client.WebClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/call")
public class ClientController {

    private WebClient webClient;
    private RestTemplate restTemplate;

    public ClientController(WebClient webClient, RestTemplate restTemplate) {
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("msg")
    public String getMsg(){

        String value = restTemplate.getForObject("http://microservice1/api/v1/message/welcome", String.class);
        return value;
    }
}
