package com.example.demomeetup.controller;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/flights")
    public Callable<List<Flight>> flights() {
        return demoService::getFlightsFromSlowService;
    }

    @GetMapping("/fast")
    public String fast() {
        return "fast";
    }

}
