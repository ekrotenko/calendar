package com.ekrotenko.calendar.Exceptions;

import java.io.IOException;

/**
 * Created by Eugene on 05.02.2017.
 */
public class EventInputException extends Exception {
    public EventInputException(String message){
        super(message);
    }

    public EventInputException (Throwable ex){
        super(ex);
    }
}
