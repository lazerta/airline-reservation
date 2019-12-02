package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_reservation")
public class Reservation implements Serializable {
    @EmbeddedId
    private ReservationId reservationId;


}
