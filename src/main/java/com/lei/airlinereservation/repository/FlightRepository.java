package com.lei.airlinereservation.repository;


import com.lei.airlinereservation.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer>, QueryByExampleExecutor<Flight> {

    List<Flight> findAllByAirlineName(String airlineName);

    @Query("update  Flight s set s.fare =:fare  where  s.id =:id")
    @Modifying
    boolean updateFare(Integer id, double fare);

    @Modifying
    @Query("update  Flight  s set s.isCancelled =: isCancelled")
    void updateIsCancelStatus(Integer flightId, boolean isCancelled);

    List<Flight> findAllByDestinationAirportNameAndArriveTimeGreaterThanEqualOrderByArriveTimeDesc
            (String destinationAirportName, LocalDateTime arriveTime);

    List<Flight> findAllByDepartureAirportNameAndDepartureTimeGreaterThanEqualOrderByDepartureTimeAsc(String departureAirportName, LocalDateTime departureTime);
}
