package com.bnt.CustomerApplication.exception;


public class IdNotFoundException extends RuntimeException{
        
    public IdNotFoundException(String msg){
         super(msg);
     }
}
