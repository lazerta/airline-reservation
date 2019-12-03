package com.lei.airlinereservation.service.impl;

import com.lei.airlinereservation.entity.Flight;
import com.lei.airlinereservation.entity.Reservation;
import com.lei.airlinereservation.entity.ReservationId;
import com.lei.airlinereservation.entity.User;
import com.lei.airlinereservation.repository.FlightRepository;
import com.lei.airlinereservation.repository.ReservationRepository;
import com.lei.airlinereservation.repository.UserRepository;
import com.lei.airlinereservation.service.ReservationService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Exception.class)
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private FlightRepository flightRepository;
    private UserRepository userRepository;

    @Override
    public List<Flight> findReservationByUsername(String username) {
        List<Reservation> reservation = reservationRepository.findAllByReservationId_CustomerUsername(username);

        List<Integer> reservationFlightIds = reservation.parallelStream().map(reservation1 -> reservation1.getReservationId().getFlightId()).collect(Collectors.toList());

        return flightRepository.findAllById(reservationFlightIds);


    }

    @Override
    public boolean cancelReservation(Integer flightId, String username) {
        ReservationId reservationId = new ReservationId(username, flightId);
        return reservationRepository.deleteByReservationId(reservationId);

    }

    @Override
    public boolean cancelFlightReservation(Integer flightId) {
        flightRepository.updateIsCancelStatus(flightId,true);
        return reservationRepository.deleteAllByReservationId_FlightId(flightId);
    }

    //    front-end
    @Override
    public boolean makeReservation(String username, Integer flightId) {

        Flight flight = flightRepository.findById(flightId).get();
        if (flight.getCapacity().equals(flight.getCount())) {
            return false;
        }
        flight.setCount(flight.getCount() + 1);
        reservationRepository.save(Reservation.create(username, flightId));
        return true;
    }


}
