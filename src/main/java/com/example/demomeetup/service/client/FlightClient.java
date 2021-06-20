package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import reactor.core.publisher.Flux;

public interface FlightClient {
    Flux<Flight> getFlights();
}
