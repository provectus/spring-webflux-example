package com.example.demomeetup.controller;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/flights")
    public Mono<List<Flight>> flights() {
        return Mono.fromCallable(demoService::getFlightsFromSlowService);
    }

    @GetMapping("/fast")
    public String fast() {
        return "fast";
    }

}
