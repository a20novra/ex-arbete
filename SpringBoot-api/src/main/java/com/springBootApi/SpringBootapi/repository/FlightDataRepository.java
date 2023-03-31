package com.springBootApi.SpringBootapi.repository;

import com.springBootApi.SpringBootapi.model.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataRepository extends JpaRepository<FlightData, Long> {

}
