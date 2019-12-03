package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;

import java.util.List;

public interface AirlineService {

    List<Flight> findByAirlineName(String airlineName);
     boolean updateFare(Integer id ,double fare);
     Flight save(Flight flight);
     boolean cancelFlight(Integer flightId);

     List<Flight> search(Flight flight);

}
