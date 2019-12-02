package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;
import org.springframework.data.domain.Page;

public interface ReservationService {
    Page<Flight> findReservationByUsername(String username);
    boolean cancelReservation(Integer flightId,String username);

}
