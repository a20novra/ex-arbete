package com.springBootApi.SpringBootapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flightdatas")
public class FlightDatas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airline_iata_code;
    private Long airline_id;
    private String source_airport_iata_code;
    private Long source_airport_id;
    private String destination_airport_iata_code;
    private Long destination_airport_id;
    private Long number_of_stops;
    private String equipment;

    public String getAirline_iata_code() {
        return airline_iata_code;
    }

    public void setAirline_iata_code(String airline_iata_code) {
        this.airline_iata_code = airline_iata_code;
    }

    public Long getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Long airline_id) {
        this.airline_id = airline_id;
    }

    public String getSource_airport_iata_code() {
        return source_airport_iata_code;
    }

    public void setSource_airport_iata_code(String source_airport_iata_code) {
        this.source_airport_iata_code = source_airport_iata_code;
    }

    public Long getSource_airport_id() {
        return source_airport_id;
    }

    public void setSource_airport_id(Long source_airport_id) {
        this.source_airport_id = source_airport_id;
    }

    public String getDestination_airport_iata_code() {
        return destination_airport_iata_code;
    }

    public void setDestination_airport_iata_code(String destination_airport_iata_code) {
        this.destination_airport_iata_code = destination_airport_iata_code;
    }

    public Long getDestination_airport_id() {
        return destination_airport_id;
    }

    public void setDestination_airport_id(Long destination_airport_id) {
        this.destination_airport_id = destination_airport_id;
    }

    public Long getNumber_of_stops() {
        return number_of_stops;
    }

    public void setNumber_of_stops(Long number_of_stops) {
        this.number_of_stops = number_of_stops;
    }

    public Long getId() {
        return id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

}
