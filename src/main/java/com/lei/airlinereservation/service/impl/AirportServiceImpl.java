package com.lei.airlinereservation.service.impl;

import com.lei.airlinereservation.entity.Flight;
import com.lei.airlinereservation.repository.FlightRepository;
import com.lei.airlinereservation.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@AllArgsConstructor
@Service
@Transactional(rollbackOn = Exception.class)
public class AirportServiceImpl implements AirportService {

    private FlightRepository flightRepository;


    @Override
    public List<Flight> findAllArriveFlight(LocalDateTime currentDate, String airportName) {
        return  flightRepository.findAllByDestinationAirportNameAndArriveTimeGreaterThanEqualOrderByArriveTimeDesc(airportName,currentDate);
    }

    @Override
    public List<Flight> findAllDepartureFlight(LocalDateTime currentDate, String airportName) {
       return  flightRepository
               .findAllByDepartureAirportNameAndDepartureTimeGreaterThanEqualOrderByDepartureTimeAsc(airportName, currentDate);
    }
}
