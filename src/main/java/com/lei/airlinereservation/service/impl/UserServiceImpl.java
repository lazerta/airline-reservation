package com.lei.airlinereservation.service.impl;

import com.lei.airlinereservation.common.Const;
import com.lei.airlinereservation.entity.ReservationId;
import com.lei.airlinereservation.entity.User;
import com.lei.airlinereservation.exceptions.AppException;
import com.lei.airlinereservation.repository.ReservationRepository;
import com.lei.airlinereservation.repository.UserRepository;
import com.lei.airlinereservation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


@AllArgsConstructor
@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    @Override
    public User findOne(String username) {
        User user = userRepository.findUserByUsername(username).orElseThrow(() -> AppException.create("User doest not exist"));


        return userRepository.findById(username).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public boolean cancelReservation(String username, Integer FlightId) {
        ReservationId id = new ReservationId(username, FlightId);
        return reservationRepository.deleteByReservationId(id);
    }


    @Override
    public User login(User user,HttpSession session) {
        User userLogged = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userLogged == null) {
            throw AppException.create("wrong username or password");
        }
        session.setAttribute(Const.currentUser, userLogged);
        return userLogged;
    }

    @Override
    public void LoginOut(HttpSession session) {
        session.removeAttribute(Const.currentUser);
    }

    @Override
    public User register(User user) {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw  AppException.create("user with user name " + user.getUsername() + "  already exist");
        }
        return userRepository.save(user);

    }


}
