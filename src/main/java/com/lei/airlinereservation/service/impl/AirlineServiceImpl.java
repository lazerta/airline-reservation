package com.lei.airlinereservation.service.impl;

import com.lei.airlinereservation.entity.Flight;
import com.lei.airlinereservation.repository.FlightRepository;
import com.lei.airlinereservation.service.AirlineService;
import com.lei.airlinereservation.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService {
    private FlightRepository flightRepository;
    private ReservationService reservationService;


    @Override
    public List<Flight> findByAirlineName(String airlineName) {
        return flightRepository.findAllByAirlineName(airlineName);
    }

    @Override
    public boolean updateFare(Integer id, double fare) {
        return flightRepository.updateFare(id, fare);
    }


    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public boolean cancelFlight(Integer flightId) {
        return reservationService.cancelFlightReservation(flightId);
    }

    @Override
    public List<Flight> search(Flight flight) {
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

        Sort sort = Sort.by(Sort.Direction.ASC, "fare","airlineName");
        return flightRepository.findAll(Example.of(flight, matcher), sort);

    }


}
