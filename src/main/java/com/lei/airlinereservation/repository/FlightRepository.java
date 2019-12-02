package com.lei.airlinereservation.repository;


import com.lei.airlinereservation.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.LocalDateTime;

public interface FlightRepository extends JpaRepository<Flight, Integer>, QuerydslPredicateExecutor<Flight> {


}
