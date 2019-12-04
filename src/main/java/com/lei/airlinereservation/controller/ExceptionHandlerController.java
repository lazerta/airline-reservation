package com.lei.airlinereservation.controller;

import com.lei.airlinereservation.common.PayLoad;
import com.lei.airlinereservation.exceptions.AppException;
import com.lei.airlinereservation.exceptions.AuthorizationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(AppException.class)
    public PayLoad appExceptionHandler(AppException e) {
        PayLoad payLoad = PayLoad.failed(e.getMessage());
        payLoad.setError(e.getError());
        return payLoad;
    }

    @ExceptionHandler(AuthorizationException.class)
    public PayLoad authorizationExceptionHandler(AuthorizationException e){
        return PayLoad.unauthorized(e.getMessage());
    }
}
