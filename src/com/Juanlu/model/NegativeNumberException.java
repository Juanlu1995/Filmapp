package com.Juanlu.model;

/**
 * Created by juanl on 22/05/2017.
 */
public class NegativeNumberException extends Exception {
    public NegativeNumberException() {}

    public NegativeNumberException(String msg){
        super(msg);
    }
}
