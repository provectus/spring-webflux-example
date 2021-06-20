package com.example.demomeetup.repository;

import com.example.demomeetup.model.Flight;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface FlightsRepository extends ReactiveMongoRepository<Flight, String> {

    Flux<Flight> findAllByPriceBetween(Integer start, Integer end);

}
