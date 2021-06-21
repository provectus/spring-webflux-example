package com.example.demomeetup.service;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.client.FlightClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final List<FlightClient> clients;

    public Flux<Flight> getFlightsFromSlowService() {
        return Flux.fromStream(clients.stream())
                .flatMap(this::getFlights);
    }

    private Flux<Flight> getFlights(FlightClient client) {
        return client.getFlights();
    }

}
