package com.example.demomeetup.service.client;

import com.example.demomeetup.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemoteFlightClient implements FlightClient {

    private final RestTemplate restTemplate;

    @Override
    public List<Flight> getFlights() {
        long startTime = System.currentTimeMillis();
        Flight remoteFlight = restTemplate.getForObject("http://localhost:8081/flights", Flight.class);
        System.out.println("Remote execution time: " + (System.currentTimeMillis() - startTime));
        return List.of(remoteFlight);
    }
}
