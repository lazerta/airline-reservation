package com.lei.airlinereservation.common;

import com.lei.airlinereservation.entity.User;

import javax.servlet.http.HttpSession;

public class Util {
    public static boolean isBank(String str) {
        return str == null || str.isBlank();
    }

    public static User currentUser(HttpSession session){
        return (User) session.getAttribute(Const.currentUser);
    }
}
