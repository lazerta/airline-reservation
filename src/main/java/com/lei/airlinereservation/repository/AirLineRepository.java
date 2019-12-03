package com.lei.airlinereservation.repository;

import com.lei.airlinereservation.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AirLineRepository extends JpaRepository<Airline, Integer> {

}
