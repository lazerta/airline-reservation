package com.lei.airlinereservation.service.impl;

import com.lei.airlinereservation.entity.Flight;
import com.lei.airlinereservation.repository.FlightRepository;
import com.lei.airlinereservation.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
@AllArgsConstructor
public class flightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    @Override
    public Flight findOne(Integer id) {
        return   flightRepository.getOne(id);
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void delete(Integer id) {
       flightRepository.deleteById(id);
    }

    @Override
    public boolean setCancel(Integer id, boolean cancel) {
        Flight flight = findOne(id);
        return false;
    }


}
