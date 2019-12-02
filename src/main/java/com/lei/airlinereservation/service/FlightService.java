package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;

public interface FlightService  {
    Flight findOne(Integer id);
    Flight save(Flight flight);
    Flight update(Flight flight);
    void  delete(Integer id);
    boolean setCancel(Integer id,boolean cancel);

}
