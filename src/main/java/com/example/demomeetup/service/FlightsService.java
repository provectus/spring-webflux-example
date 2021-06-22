package com.example.demomeetup.service;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.client.FlightClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightsService {

    private final List<FlightClient> clients;

    public Flux<List<Flight>> getFlightsFromClients() {
        return Flux.fromStream(clients.stream())
                .flatMap(this::getFlights);
    }

    private Mono<List<Flight>> getFlights(FlightClient client) {
        return Mono.fromCallable(client::getFlights).subscribeOn(Schedulers.boundedElastic());
    }

}
