package com.lei.airlinereservation.controller;

import com.lei.airlinereservation.common.Const;
import com.lei.airlinereservation.entity.User;
import com.lei.airlinereservation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
@AllArgsConstructor
public class HomeController {
    private   UserService userService;

    @GetMapping("/login")
    String login(Model model) {
         return "login";
    }
    @PostMapping("/login")
    String loginForm(HttpSession session,  User user,Model model){
        User user1 = userService.login(user);
          if (user1 == null){
              model.addAttribute("errorMessage", "invalid credentials");
              return "login";
          }

        session.setAttribute(Const.currentUser, user1);
        model.addAttribute(Const.currentUser, user1);
        return   "user";

    }
}
