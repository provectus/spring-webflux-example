package com.example.demomeetup.repository;

import com.example.demomeetup.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightsRepository extends MongoRepository<Flight, String> {

    List<Flight> findAllByPriceBetween(Integer start, Integer end);

}
