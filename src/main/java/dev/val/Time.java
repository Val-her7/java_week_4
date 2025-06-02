package dev.val;

import java.time.LocalTime;
import org.springframework.stereotype.Component;

@Component
public class Time implements Command{
    @Override
    public void execute(){
        System.out.println("Current time is: " + LocalTime.now());
    }
    @Override
    public String getName(){
        return "time";
    }
}