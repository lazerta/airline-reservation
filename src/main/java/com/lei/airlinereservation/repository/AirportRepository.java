package com.lei.airlinereservation.repository;

import com.lei.airlinereservation.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Integer> {

}
