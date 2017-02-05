package com.ekrotenko.calendar.IO.Output;

import com.ekrotenko.calendar.Core.Event;
import com.ekrotenko.calendar.Exceptions.EventOutputException;

import java.io.*;
import java.util.List;

/**
 * Created by Eugene on 03.02.2017.
 */
public class FileOutput implements Output {
    private final String outputFilePath = "data.txt";

    @Override
    public void outputData(List<Event> events) throws EventOutputException{
        final String fileName = "data.txt";
        File newFile = new File(fileName);
        try{
            newFile.createNewFile();
        }
        catch (IOException ex){
            throw new EventOutputException(ex);
        }
        try(FileWriter writer = new FileWriter(newFile, false)){
            for(Event e: events){
                writer.append("["+e.getLocation()+"]"+" "+"["+e.getSummary()+"]"+" "+"["+e.getStartTime()+"]"+"\n");
            }
            writer.flush();
        }
        catch (IOException ex){
            throw new EventOutputException(ex);
        }

    }
}
