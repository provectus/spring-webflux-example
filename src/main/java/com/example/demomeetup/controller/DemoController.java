package com.example.demomeetup.controller;

import com.example.demomeetup.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/data")
    public List<String> data() {
        return IntStream.rangeClosed(1, 3)
                .parallel()
                .mapToObj(i -> demoService.getDataFromSlowService())
                .collect(Collectors.toList());
    }

    @GetMapping("/fast")
    public String fast() {
        int i = 5;
        return "fast";
    }

}
