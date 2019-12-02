package com.lei.airlinereservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Entity
@AllArgsConstructor
@Builder
@ToString(exclude = {"users", "airline"})
@EqualsAndHashCode(exclude = {"users", "airline"})
@Table(name = "tbl_flight")
@NoArgsConstructor
public class Flight implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "count")
    private Integer count = 0;

    @Column(name = "fare")
    private Double fare;

    @JoinColumn(name = "departure_airport_id")
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})
    private Airport  departure;
    @JoinColumn(name = "airline_id")
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})
    private Airline airline;

    @JoinColumn(name = "destination_airport_id")
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})
    private Airport arrive;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrive_time")
    private LocalDateTime arriveTime;

    private boolean canceled = false;
    @ManyToMany(mappedBy = "reservations")
    private Set<User> users;

}
