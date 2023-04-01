package com.springBootApi.SpringBootapi.controller;

import com.springBootApi.SpringBootapi.model.FlightDatas;
import com.springBootApi.SpringBootapi.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightDataController {
    @Autowired
    private FlightDataRepository flightDataRepository;

    @GetMapping("/flightdata")
    public List<FlightDatas> getAllFlightData() {
        System.out.println("API-anrop mottaget!");

        return flightDataRepository.findAll();
    }

    @GetMapping("/flightdata/{id}")
    public FlightDatas getFlightDataById(@PathVariable Long id) {
        return flightDataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FlightData", "id", id));
    }
}
