package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import com.example.demomeetup.repository.FlightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DatabaseFlightClient implements FlightClient {

    private final FlightsRepository repository;
    private final Random r = new Random();

    @Override
    public List<Flight> getFlights() {
        int start = r.nextInt(100);
        long startTime = System.currentTimeMillis();
        List<Flight> result = repository.findAllByPriceBetween(start, start + 2);
        System.out.println("Database execution time: " + (System.currentTimeMillis() - startTime));
        return result;
    }
}
