package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RemoteFlightClient implements FlightClient {

    private final WebClient webClient;

    @Override
    public Flux<Flight> getFlights() {
        return webClient.get()
                .uri("/flights")
                .exchangeToFlux(r -> r.bodyToFlux(Flight.class));
    }
}
