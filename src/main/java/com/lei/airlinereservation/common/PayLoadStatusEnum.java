package com.lei.airlinereservation.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PayLoadStatusEnum {
    SUCCESS(1,"success"),
    FAILED(2,"failed"),
    UNAUTHORIZED(3,"unauthorized");
    private Integer code;
    private String message;



}
