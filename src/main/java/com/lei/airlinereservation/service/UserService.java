package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.Flight;
import com.lei.airlinereservation.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;

public interface UserService {
    User findOne(String username );
    User save(User user);
    User update(User user);
    void delete(String username);
    Page<Flight> reservationPages(Pageable pageable,String username);
    boolean cancelReservation(Flight flight);


    User login(User user);
    void LoginOut(HttpSession session);

    User register(User user);
}
