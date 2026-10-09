package com.ms2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice1", url = "http://localhost:8082")
public interface WebClient {

    @GetMapping("/api/v1/message/welcome")
    public String getMessageWelcome();
}
