package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_airline")
@Data
public class Airline implements Serializable {
    @Id
    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "airport_name")
    private String airportName;

}
