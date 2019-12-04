package com.lei.airlinereservation.controller;

import com.lei.airlinereservation.common.PayLoad;
import com.lei.airlinereservation.entity.User;
import com.lei.airlinereservation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/")
@RestController
@AllArgsConstructor
public class HomeController {
    private UserService userService;

    @PostMapping("login")
    public PayLoad<User> login(@RequestBody User user, HttpSession session) {

       User user1 = userService.login(user,session);
       if (user1 == null){
           return PayLoad.failed();
       }
       return PayLoad.success(user1);
    }

    @PostMapping("logout")
     public PayLoad  logout(HttpServletRequest request){
        userService.LoginOut(request.getSession());
        return  PayLoad.success();
     }

     @PostMapping("register")
     public  PayLoad<User> register(@RequestBody User user){
          return PayLoad.success( userService.register(user));
     }


}
