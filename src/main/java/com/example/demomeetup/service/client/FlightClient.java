package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FlightClient {
    List<Flight> getFlights();
}
