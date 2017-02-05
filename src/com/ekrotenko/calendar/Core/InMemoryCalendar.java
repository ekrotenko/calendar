package com.ekrotenko.calendar.Core;

import com.ekrotenko.calendar.Exceptions.EventOutputException;
import com.ekrotenko.calendar.IO.Output.FileOutput;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Eugene on 31.01.2017.
 */
public class InMemoryCalendar implements Calendar {
    private TreeMap<LocalDateTime, Event> events = new TreeMap<>();
    private HashMap<String, HashMap<LocalDateTime,Event>> eventsByLocation=new HashMap<>();
    private final FileOutput output = new FileOutput();


    @Override
    public void addEvent(Event event){
        Event oldEvent = events.put(event.getStartTime(), event);
        if(oldEvent!=null) {
            eventsByLocation.get(oldEvent.getLocation()).remove(oldEvent.getStartTime());
        }
        if(eventsByLocation.get(event.getLocation())==null){
            HashMap<LocalDateTime, Event> submap = new HashMap<>();
            submap.put(event.getStartTime(), event);
            eventsByLocation.put(event.getLocation(),submap);
        }
        else{
            eventsByLocation.get(event.getLocation()).put(event.getStartTime(),event);
        }
        try {
            output.outputData(getAllEvents());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private List<Event> getAllEvents(){
        List<Event> eventsList = new LinkedList<>();
        for (Event e:events.values()){
            eventsList.add(e);
        }
        return eventsList;
    }

    @Override
    public List<Event> getEventsInInterval(LocalDateTime from, LocalDateTime to) {
        List<Event> eventsByDate = new LinkedList<>();
        Map<LocalDateTime, Event> subMap = events.subMap(from, true, to, true);
        for(Event e: subMap.values()){
            eventsByDate.add(e);
        }
        return eventsByDate;
    }

    @Override
    public List<Event> getEventsInLocation(String location) {
        List<Event> eventsToReturn = new LinkedList<>();
        HashMap<LocalDateTime, Event> eventsInLOcation = eventsByLocation.get(location);
        for(Event e: eventsInLOcation.values())
            eventsToReturn.add(e);
        return eventsToReturn;
    }

    @Override
    public void removeEvent(LocalDateTime startTime) {
        Event eToRemove=events.remove(startTime);
        eventsByLocation.get(eToRemove.getLocation()).remove(startTime);
        try {
            output.outputData(getAllEvents());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
