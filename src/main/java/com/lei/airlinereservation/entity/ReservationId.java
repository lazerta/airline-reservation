package com.lei.airlinereservation.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
public class ReservationId implements Serializable {
    @Column(name = "customer_username")
    private String customerUsername;

    @Column(name = "flight_id")
    private Integer flightId;
}
