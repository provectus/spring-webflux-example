package com.example.demomeetup.service;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.client.FlightClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final List<FlightClient> clients;

    public Flux<List<Flight>> getFlightsFromSlowService() {
        List<Mono<List<Flight>>> collect = clients.stream()
                .map(c -> getFlights(c))
                .collect(Collectors.toList());
        return Flux.merge(collect);
    }

    private Mono<List<Flight>> getFlights(FlightClient client) {
        return Mono.fromCallable(() -> client.getFlights()).subscribeOn(Schedulers.boundedElastic());
    }

}
