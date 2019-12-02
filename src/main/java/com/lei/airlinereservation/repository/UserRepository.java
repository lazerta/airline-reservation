package com.lei.airlinereservation.repository;

import com.lei.airlinereservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,String> {
    Optional<User> findUserByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    boolean existsUserByUsername(String username);
    void  cancelReservation(String username,Integer flightID);



}
