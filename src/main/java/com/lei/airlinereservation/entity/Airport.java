package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_airport")
public class Airport implements Serializable {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
}

