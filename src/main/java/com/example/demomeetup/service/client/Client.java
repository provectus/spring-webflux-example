package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Client implements FlightClient {
    @Override
    @SneakyThrows
    public List<Flight> getFlights() {
        Thread.sleep(2000);
        return List.of();
    }
}
