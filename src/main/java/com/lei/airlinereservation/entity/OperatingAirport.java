package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_operating_airport")
public class OperatingAirport implements Serializable {
    @Id
    @Column(name = "operating_airline_name")
    private String operatingAirlineName;

    @Id
    @Column(name = "operating_airport_name")
    private String operatingAirportName;


}
