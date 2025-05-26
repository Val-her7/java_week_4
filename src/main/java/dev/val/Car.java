package dev.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    Engine engine;

    @Autowired
    public Car(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        engine.start();
        System.out.println("The car drives!");
    }
}
