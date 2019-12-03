package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReservationService {
    List<Flight> findReservationByUsername(String username);
    boolean cancelReservation(Integer flightId,String username);

    public  boolean cancelFlightReservation(Integer flightId);
    public boolean makeReservation(String username, Integer flightId);

}
