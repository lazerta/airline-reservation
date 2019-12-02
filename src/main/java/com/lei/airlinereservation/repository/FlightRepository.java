package com.lei.airlinereservation.repository;

import com.lei.airlinereservation.entity.Flight;
import com.lei.airlinereservation.entity.QFlight;
import com.lei.airlinereservation.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Set;

public interface FlightRepository extends JpaRepository<Flight, Integer>, QuerydslPredicateExecutor<Flight> {
   Page<Flight> findAllByArrive_NameAndArriveTime(String arrive_name, LocalDateTime arriveTime, Pageable pageable);


}
