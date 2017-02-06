import com.ekrotenko.calendar.Core.Event;
import com.ekrotenko.calendar.Core.InMemoryCalendar;
import com.ekrotenko.calendar.IO.Input.FileInput;
import com.ekrotenko.calendar.IO.Input.Input;
import com.ekrotenko.calendar.UserInterface.ConsoleInterface;

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
    }
}
