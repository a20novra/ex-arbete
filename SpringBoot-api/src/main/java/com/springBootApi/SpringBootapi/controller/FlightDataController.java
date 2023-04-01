package com.springBootApi.SpringBootapi.controller;

import com.springBootApi.SpringBootapi.model.FlightDatas;
import com.springBootApi.SpringBootapi.service.FlightDataService;
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
    private FlightDataService flightDataService;

    @GetMapping("/flightdata")
    public List<FlightDatas> getAllFlightData() {
        System.out.println("API-anrop mottaget!");

        return flightDataService.getAllFlightData();
    }

    @GetMapping("/flightdata/{id}")
    public FlightDatas getFlightDataById(@PathVariable Long id) {
        return flightDataService.getFlightDataById(id);
    }
}
