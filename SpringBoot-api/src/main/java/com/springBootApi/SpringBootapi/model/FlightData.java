package com.springBootApi.SpringBootapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flightdata")
public class FlightData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airline;

    @Column(name = "airlineId")
    private Integer airlineId;

    @Column(name = "sourceAirport")
    private String sourceAirport;

    @Column(name = "sourceAirportId")
    private Integer sourceAirportId;

    @Column(name = "destinationAirport")
    private String destinationAirport;

    @Column(name = "destinationAirportId")
    private Integer destinationAirportId;

    private Integer stops;

    private String equipment;
}
