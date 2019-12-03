package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;
import org.springframework.data.jpa.repository.Query;

public interface FlightService  {
    Flight findOne(Integer id);
    Flight save(Flight flight);
    Flight update(Flight flight);
    void  delete(Integer id);



}
