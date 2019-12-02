package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_flight")
public class Flight implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "count")
    private Integer count;

    @Column(name = "fare")
    private Double fare;

    @Column(name = "departure_airport_name")
    private String departureAirportName;

    @Column(name = "destination_airport_name")
    private String destinationAirportName;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrive_time")
    private LocalDateTime arriveTime;

    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "isCancelled")
    private Boolean isCancelled;


}
