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
    public Long getId() {
        return id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Long getSourceAirportId() {
        return sourceAirportId;
    }

    public void setSourceAirportId(Long sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Long getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(Long destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public Long getStops() {
        return stops;
    }

    public void setStops(Long stops) {
        this.stops = stops;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

}
