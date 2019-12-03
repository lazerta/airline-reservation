package com.lei.airlinereservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_reservation")
@NoArgsConstructor
public class Reservation implements Serializable {
    @EmbeddedId
    @Id
    private ReservationId reservationId;

    public static Reservation create(String username, Integer flightId) {
        ReservationId reservationId = new ReservationId(username, flightId);
        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        return reservation;
    }


}
