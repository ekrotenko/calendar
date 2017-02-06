package com.ekrotenko.calendar.UserInterface;

import com.ekrotenko.calendar.Core.Event;

import java.time.LocalDateTime;

/**
 * Created by Eugene on 06.02.2017.
 */
public interface UserInterface {
    Event createEvent(String location, String summary, LocalDateTime startTime);
}
