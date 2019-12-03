package com.lei.airlinereservation.dto;

import com.lei.airlinereservation.entity.Flight;
import lombok.Data;

import java.util.List;

@Data
public class UserProfileDto {

    private String username;
    private String email;
    private String alias;
    private List<Flight> flights;
}
