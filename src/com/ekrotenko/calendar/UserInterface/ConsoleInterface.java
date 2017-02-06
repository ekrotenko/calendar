package com.ekrotenko.calendar.UserInterface;

import com.ekrotenko.calendar.Core.Event;
import com.ekrotenko.calendar.Core.InMemoryCalendar;
import com.ekrotenko.calendar.Exceptions.EventInputException;
import com.ekrotenko.calendar.UserInterface.UserInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by Eugene on 06.02.2017.
 */
public class ConsoleInterface implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private InMemoryCalendar calendar;

    public ConsoleInterface(InMemoryCalendar calendar){
        this.calendar=calendar;
    }

    @Override
    public Event createEvent(String location, String summary, LocalDateTime startTime) {
        return new Event(startTime, summary, location);
    }

    public void mainDialog() {
        System.out.println("1-Add new event");
        System.out.println("2-Remove Event");
        System.out.println("3-Get events in interval");
        System.out.println("4-Get events in location");
        System.out.println("0-Close program");
        System.out.println("\n");
        try {
            callAction();
        }
        catch(EventInputException ex)
        {ex.printStackTrace();}
    }

    private void callAction() throws EventInputException{
        int id = Integer.parseInt(scanner.nextLine());
        switch(id){
            case 1:
                calendar.addEvent(createEvent(getLocation(), getSummary(),getStartDate()));
                break;
            case 2:
                calendar.removeEvent(getStartDate());
                break;
            case 3:
                System.out.println("Start time FROM");
                LocalDateTime from = getStartDate();
                System.out.println("Start time TO");
                calendar.getEventsInInterval(from, getStartDate());
                break;
            case 4:
                calendar.getEventsInLocation(getLocation());
                break;
            case 0:
                System.exit(0);
            default: throw new EventInputException("Incorrect choice");
        }
    }

    private String getLocation(){
        System.out.println("Input Location name:");
        System.out.println("\n> ");
        return scanner.nextLine();
    }

    private String getSummary(){
        System.out.println("Input Summary name:");
        System.out.println("\n> ");
        return scanner.nextLine();
    }

    private LocalDateTime getStartDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Input Start time in format year-month-day hours:minutes (e.g 2017-02-19 23:00):");
        System.out.println("\n> ");
        return LocalDateTime.parse(scanner.nextLine(), formatter);
    }
}
