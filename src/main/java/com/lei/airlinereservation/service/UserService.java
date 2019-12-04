package com.lei.airlinereservation.service;

import com.lei.airlinereservation.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    User findOne(String username );
    User save(User user);
    User update(User user);
    void delete(String username);
    boolean cancelReservation(String username,Integer FlightId);
    User login(User user,HttpSession session);
    void LoginOut(HttpSession session);

    User register(User user);

}
