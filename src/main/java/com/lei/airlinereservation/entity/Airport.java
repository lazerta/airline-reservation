package com.lei.airlinereservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString(exclude = {"airlines"})
@EqualsAndHashCode(exclude = {"airlines"})
@Data
@Entity
@Table(name = "tbl_airport")
public class Airport implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,}, fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_operating_airport",
            joinColumns = @JoinColumn(name = "operating_airport_id"),
            inverseJoinColumns = @JoinColumn(name = "operating_airline_id")
    )
    @JsonIgnore
    private Set<Airline> airlines = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "departure",orphanRemoval = true)
    private Set<Flight> departureFlights = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "arrive",orphanRemoval = true)
    private Set<Flight> arriveFlight = new HashSet<>();


}
