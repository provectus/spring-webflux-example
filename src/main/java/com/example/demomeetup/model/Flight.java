package com.example.demomeetup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "flights")
public class Flight {
    @Id
    private String flightId;
    private String departure;
    private String arrival;
    private Integer price;
}
