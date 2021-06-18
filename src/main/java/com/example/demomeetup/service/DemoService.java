package com.example.demomeetup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final RestTemplate restTemplate = new RestTemplate();

    //@Async
    public String getDataFromSlowService() {
        String forObject = restTemplate.getForObject("http://localhost:8081/data/slow", String.class);
        return forObject + "12w12w";
    }

}
