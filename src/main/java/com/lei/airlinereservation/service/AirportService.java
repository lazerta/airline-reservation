package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface AirportService {

    List<Flight> findAllArriveFlight(LocalDateTime currentDate, String airportName);
    List<Flight> findAllDepartureFlight(LocalDateTime currentDate,String airportName);


}
