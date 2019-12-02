package com.lei.airlinereservation.common;

import com.lei.airlinereservation.entity.User;

public class Util {
    public static boolean isBank(String str) {
        return str == null || str.isBlank();
    }
}
