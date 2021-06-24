package com.example.demomeetup.controller;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightsController {

    private final FlightsService flightsService;

    @GetMapping("/flights")
    public Mono<List<Flight>> flights() {
        return Mono.fromCallable(flightsService::getFlightsFromClients);
    }

    @GetMapping("/fast")
    public String fast() {
        return "fast";
    }

}
