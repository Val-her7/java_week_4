package dev.val;

import java.util.MissingResourceException;

public class Challenge1 {
    public static void main(String[] args) {
        try{
        System.out.println(SayHello.greet());
        }
        catch(MissingResourceException e) {
            System.out.println("Resource properties not found!");
        }
    }
}
