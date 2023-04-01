package com.springBootApi.SpringBootapi.service;

import com.springBootApi.SpringBootapi.model.FlightDatas;

import java.util.List;

public interface FlightDataService {
    public List<FlightDatas> getAllFlightData();
    public FlightDatas getFlightDataById(Long id);
    public FlightDatas createFlightData(FlightDatas flightData);
}
