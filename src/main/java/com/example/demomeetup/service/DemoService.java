package com.example.demomeetup.service;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.client.FlightClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final List<FlightClient> clients;

    public Flux<Flight> getFlightsFromSlowService() {
        List<Flux<Flight>> collect = clients.stream()
                .map(FlightClient::getFlights)
                .collect(Collectors.toList());
        return Flux.merge(collect);
    }

}
