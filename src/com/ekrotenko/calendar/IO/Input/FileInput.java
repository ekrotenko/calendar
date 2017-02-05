package com.ekrotenko.calendar.IO.Input;

import com.ekrotenko.calendar.Core.Event;
import com.ekrotenko.calendar.Core.InMemoryCalendar;
import com.ekrotenko.calendar.Exceptions.EventInputException;
import com.ekrotenko.calendar.Exceptions.EventOutputException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Eugene on 03.02.2017.
 */
public class FileInput implements Input{
    private final String fileName = "data.txt";

    @Override
    public InMemoryCalendar getData() throws EventInputException, EventOutputException {
        InMemoryCalendar calendar = new InMemoryCalendar();
        try {
            for (Event e : getEvents(getInputStream()))
                calendar.addEvent(e);
        }
        catch (FileNotFoundException ex){
            throw new EventOutputException(ex);
        }
        return calendar;
    }

    private InputStream getInputStream() throws FileNotFoundException{
        return new BufferedInputStream(new FileInputStream(fileName));
    }

    private List<Event> getEvents(InputStream is){
        Scanner reader = new Scanner(is);
        List<Event> events = new LinkedList<>();
        while(reader.hasNextLine()){
            events.add(parseEventFromString(reader.nextLine()));
        }
        return events;
    }

    private Event parseEventFromString(String strEvent){
        strEvent=strEvent.substring(1,strEvent.length()-1);
        String [] strArray = strEvent.split("\\] \\[");
        return new Event(LocalDateTime.parse(strArray[2]), strArray[1], strArray[0]);
    }
}
