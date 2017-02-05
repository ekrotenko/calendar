package com.ekrotenko.calendar.Exceptions;

import java.io.IOException;

/**
 * Created by Eugene on 05.02.2017.
 */
public class EventOutputException extends Exception {
    public EventOutputException(String message){
        super(message);
    }

    public EventOutputException(Throwable ex){
        super(ex);
    }
}
