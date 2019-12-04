package com.lei.airlinereservation.controller;

import com.lei.airlinereservation.common.PayLoad;
import com.lei.airlinereservation.exceptions.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(AppException.class)
    public PayLoad appException(AppException e) {
        PayLoad payLoad = PayLoad.failed(e.getMessage());
        payLoad.setError(e.getError());
        return payLoad;
    }
}
