package dev.val;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationWithXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Team myteam = (Team) context.getBean("team");
        myteam.play();
        System.out.println(myteam.getName());

        Player myplayer = (Player) context.getBean("player");
        System.out.println(myplayer.age);
    }
}