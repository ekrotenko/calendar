package com.ekrotenko.calendar.Core;

import com.ekrotenko.calendar.Exceptions.EventOutputException;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Eugene on 31.01.2017.
 */
public interface Calendar {
    void addEvent(Event event) throws EventOutputException;
    List<Event> getEventsInInterval(LocalDateTime from, LocalDateTime to); //sorted
    List<Event> getEventsInLocation(String location);
    void removeEvent (LocalDateTime startTime);

}
