package com.example.demomeetup.service;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.service.client.FlightClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightsService {

    private final List<FlightClient> clients;

    public List<Flight> getFlightsFromClients() {
        return clients.stream()
                .parallel()
                .flatMap(c -> c.getFlights().stream())
                .collect(Collectors.toList());
    }

}
