package com.example.demomeetup.controller;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/flights")
    public List<Flight> flights() {
        //long start = System.currentTimeMillis();
        var result = demoService.getFlightsFromSlowService();
        //System.out.println("Execution time: " + (System.currentTimeMillis() - start));
        return result;
    }

    @GetMapping("/fast")
    public String fast() {
        return "fast";
    }

}
