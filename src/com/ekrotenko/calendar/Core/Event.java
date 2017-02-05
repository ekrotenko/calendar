package com.ekrotenko.calendar.Core;

import java.time.LocalDateTime;

/**
 * Created by Eugene on 31.01.2017.
 */
public class Event {
    private final LocalDateTime startTime;
    private final String summary;
    private final String location;

    public Event(LocalDateTime startTime, String summary, String location){
        this.startTime = startTime;
        this.summary = summary;
        this.location = location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getSummary() {
        return summary;
    }

    public String getLocation() {
        return location;
    }
}
