package com.lei.airlinereservation.controller;

import com.lei.airlinereservation.common.PayLoad;
import com.lei.airlinereservation.common.Util;
import com.lei.airlinereservation.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping(value = "/{username}")
   public PayLoad<User> userProfile(HttpSession session, @PathVariable String username){
       User user = Util.currentUser(session);
       if (user == null|| !user.getUsername().equals(username)){
         return   PayLoad.unauthorized();
       }
       return PayLoad.success(user);

   }

}
