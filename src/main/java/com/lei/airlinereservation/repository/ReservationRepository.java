package com.lei.airlinereservation.repository;

import com.lei.airlinereservation.entity.Reservation;
import com.lei.airlinereservation.entity.ReservationId;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

   List<Reservation> findAllByReservationId_CustomerUsername(String reservationId_customerUsername);
   List<Reservation> findAllByReservationId_FlightId(Integer reservationId_flightId);

   boolean deleteAllByReservationId_FlightId(Integer reservationId_flightId);
   boolean deleteByReservationId(ReservationId reservationId);
}
