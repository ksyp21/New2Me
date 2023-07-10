package com.ecommerce.new2me.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException(String msg){
        super(msg);
    }

}
