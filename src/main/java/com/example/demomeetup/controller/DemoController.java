package com.example.demomeetup.controller;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping(value = "/flights", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Flight> flights() {
        return demoService.getFlightsFromSlowService();
    }

    @GetMapping("/fast")
    public Mono<String> fast() {
        return Mono.just("fast");
    }

}
