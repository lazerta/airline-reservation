package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_reservation")
public class Reservation implements Serializable {
    @Id
    @Column(name = "customer_username")
    private String customerUsername;

    @Id
    @Column(name = "flight_id")
    private Integer flightId;


}
