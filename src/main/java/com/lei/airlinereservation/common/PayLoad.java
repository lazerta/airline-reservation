package com.lei.airlinereservation.common;

import lombok.Data;

import java.util.Map;

@Data
public class PayLoad<T> {
    private Integer status;
    private String message;
    private T data;
    private Map<String, String> error;

    private PayLoad(PayLoadStatusEnum status, T data, Map<String, String> error) {
        this.status = status.getCode();
        this.message = status.getMessage();
        this.data = data;
        this.error = error;
    }

    public static <T> PayLoad<T> unauthorized() {
        return new PayLoad<>(PayLoadStatusEnum.UNAUTHORIZED, null, null);
    }

    public static <T> PayLoad<T> unauthorized(String message) {
        PayLoad<T> objectPayLoad = new PayLoad<>(PayLoadStatusEnum.UNAUTHORIZED, null, null);
        objectPayLoad.setMessage(message);
        return objectPayLoad;
    }
    public static <T> PayLoad<T> success() {
        return new PayLoad<>(PayLoadStatusEnum.SUCCESS, null, null);
    }

    public static <T> PayLoad<T> success(T data) {
        return new PayLoad<>(PayLoadStatusEnum.SUCCESS, data, null);
    }

    public static <T> PayLoad<T> failed(Map<String, String> errors) {
        return new PayLoad<>(PayLoadStatusEnum.FAILED, null, errors);
    }

    public static <T> PayLoad<T> failed() {
        return new PayLoad<>(PayLoadStatusEnum.FAILED, null, null);
    }

    public static <T> PayLoad<T> failed(String message) {
        PayLoad<T> payLoad = new PayLoad<>(PayLoadStatusEnum.FAILED, null, null);
        payLoad.setMessage(message);
        return payLoad;
    }
}
