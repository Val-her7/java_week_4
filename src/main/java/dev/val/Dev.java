package dev.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired
    @Qualifier("desktop")
    Computer computer;

    
    // public Dev(Computer computer){
    //     this.computer = computer;
    // }

    public void build(){
        computer.compile();
        System.out.println("Working on a project!");
    }
}