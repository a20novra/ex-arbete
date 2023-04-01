package com.springBootApi.SpringBootapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flightdatas")
public class FlightDatas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airline;
    private Long airlineId;
    private String sourceAirport;
    private Long sourceAirportId;
    private String destinationAirport;
    private Long destinationAirportId;
    private Long stops;
    private String equipment;
}
