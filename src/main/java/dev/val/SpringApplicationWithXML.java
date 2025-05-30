package dev.val;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationWithXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Team myteam = (Team) context.getBean("team");
        myteam.play();
        System.out.println(myteam.getName());

        Player myplayer = context.getBean(Player.class);
        System.out.println(myplayer.age);
        ((AnnotationConfigApplicationContext) context).close();
    }
}