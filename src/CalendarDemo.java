import com.ekrotenko.calendar.Core.Event;
import com.ekrotenko.calendar.Core.InMemoryCalendar;
import com.ekrotenko.calendar.Exceptions.EventOutputException;
import com.ekrotenko.calendar.IO.Input.FileInput;
import com.ekrotenko.calendar.IO.Input.Input;
import com.ekrotenko.calendar.UserInterface.ConsoleInterface;
import com.ekrotenko.calendar.UserInterface.UserInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CalendarDemo {

    public static void main(String[] args) {
        InMemoryCalendar calendar = new InMemoryCalendar();
        Input input = new FileInput();
        try {
            calendar = input.getData();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        ConsoleInterface ui = new ConsoleInterface(calendar);
        while(true){
            ui.mainDialog();
        }




        // write your code here
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//
//        Event event1 = new Event(LocalDateTime.parse("2017-02-19 22:00", formatter), "My Birthday Party", "Bartolomeo");
//        Event event2 = new Event(LocalDateTime.parse("2017-01-01 22:00", formatter), "New Year Party", "Bartolomeo");
//        Event event3 = new Event(LocalDateTime.parse("2017-02-01 17:00", formatter), "Hair Cut", "Barbershop");
//        Event event4 = new Event(LocalDateTime.parse("2017-02-03 17:00", formatter), "Dating", "Coast");
        //Event event1 = new Event(LocalDateTime.parse("2017-02-20 17:00", formatter), "CEO meeting", "HQ office");
//        Event event1 = new Event(LocalDateTime.parse("2017-02-19 22:00", formatter), "My Birthday Party", "Bartolomeo");
//        Event event2 = new Event(LocalDateTime.parse("2017-01-01 22:00", formatter), "New Year Party", "Bartolomeo");
//        Event event3 = new Event(LocalDateTime.parse("2017-02-01 17:00", formatter), "Hair Cut", "Barbershop");
//        Event event4 = new Event(LocalDateTime.parse("2017-02-01 17:00", formatter), "Dating", "Coast");



        //List<Event> events = myCalendar.getEventsInInterval(event2.getStartTime(), event1.getStartTime());
        //List<Event> eInLOcation = myCalendar.getEventsInLocation("Bartolomeo");

    }
}
