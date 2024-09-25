package com.bnt.CustomerApplication.exception;

public class DataIsNotPresentException extends RuntimeException {
          
    public DataIsNotPresentException(String msg){
        super(msg);
    }
}
