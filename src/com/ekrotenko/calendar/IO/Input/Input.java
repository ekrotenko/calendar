package com.ekrotenko.calendar.IO.Input;

import com.ekrotenko.calendar.Core.InMemoryCalendar;
import com.ekrotenko.calendar.Exceptions.EventInputException;
import com.ekrotenko.calendar.Exceptions.EventOutputException;

/**
 * Created by Eugene on 03.02.2017.
 */
public interface Input {
    InMemoryCalendar getData() throws EventInputException, EventOutputException;
}
