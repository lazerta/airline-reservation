package com.lei.airlinereservation.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class AppException  extends RuntimeException{

    private Map<String,String> error;

    private AppException(String message, Throwable cause, Map<String, String> error) {
        super(message, cause);
        this.error = error;
    }
    public static  AppException create(String message){
       return  new AppException(message, null, null);
    }

   public static AppException create(String message,Map<String,String> error){
        return  new AppException(message,null,error);
    }
    public  static AppException create(String message,Throwable throwable,Map<String,String> error){
        return  new AppException(message,throwable,error);
    }
}
