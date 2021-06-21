package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemoteFlightClient implements FlightClient {

    private final RestTemplate restTemplate;

    @Override
    public Mono<List<Flight>> getFlights() {
        Flight remoteFlight = restTemplate.getForObject("http://localhost:8081/flights", Flight.class);
        return Mono.just(List.of(remoteFlight));
    }
}
