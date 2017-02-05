package com.ekrotenko.calendar.IO.Output;

import com.ekrotenko.calendar.Core.Event;
import com.ekrotenko.calendar.Exceptions.EventOutputException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Eugene on 03.02.2017.
 */
public interface Output {
    void outputData(List<Event> events) throws EventOutputException;
}
