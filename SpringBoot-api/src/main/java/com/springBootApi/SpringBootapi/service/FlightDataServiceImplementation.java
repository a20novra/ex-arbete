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
        return flightDataRepository.save(flightData);
    }
}
