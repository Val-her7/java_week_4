package dev.val;

import org.springframework.stereotype.Component;

@Component
public class Hello implements Command{
    @Override
    public void execute(){
        System.out.println("Hello world");
    }
    @Override
    public String getName(){
        return "hello";
    }
}