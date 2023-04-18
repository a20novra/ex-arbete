package com.springBootApi.SpringBootapi.service;

import com.springBootApi.SpringBootapi.controller.ResourceNotFoundException;
import com.springBootApi.SpringBootapi.model.FlightDatas;
import com.springBootApi.SpringBootapi.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightDataServiceImplementation  implements FlightDataService{
    @Autowired
    private FlightDataRepository flightDataRepository;

    @Override
    public List<FlightDatas> getAllFlightData() {
        System.out.println("API-anrop mottaget!");

        return flightDataRepository.findAll();
    }

    @Override
    public FlightDatas getFlightDataById(Long id) {
        return flightDataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FlightData", "id", id));
    }
    @Override
    public FlightDatas createFlightData(FlightDatas flightData){
        // Validate data
        if (flightData.getAirline_iata_code() == null || flightData.getAirline_iata_code().isEmpty() || flightData.getAirline_iata_code().length() > 3){
            throw new IllegalArgumentException("Invalid airline IATA code");
        }
        if (flightData.getAirline_id() == null || flightData.getAirline_id() <= 0){
            throw new IllegalArgumentException("Invalid airline ID");
        }
        if (flightData.getSource_airport_iata_code() == null || flightData.getSource_airport_iata_code().isEmpty() || flightData.getSource_airport_iata_code().length() > 4){
            throw new IllegalArgumentException("Invalid source airport IATA code");
        }
        if (flightData.getSource_airport_id() == null || flightData.getSource_airport_id() <= 0){
            throw new IllegalArgumentException("Invalid source airport ID");
        }
        if (flightData.getDestination_airport_iata_code() == null || flightData.getDestination_airport_iata_code().isEmpty() || flightData.getDestination_airport_iata_code().length() > 4){
            throw new IllegalArgumentException("Invalid destination airport IATA code");
        }
        if (flightData.getDestination_airport_id() == null || flightData.getDestination_airport_id() <= 0){
            throw new IllegalArgumentException("Invalid destination airport ID");
        }
        if (flightData.getNumber_of_stops() == null || flightData.getNumber_of_stops() < 0){
            throw new IllegalArgumentException("Invalid number of stops");
        }
        if (flightData.getEquipment() == null || flightData.getEquipment().isEmpty() || flightData.getEquipment().length() > 32){
            throw new IllegalArgumentException("Invalid equipment");
        }

        return flightDataRepository.save(flightData);
    }
    
}
