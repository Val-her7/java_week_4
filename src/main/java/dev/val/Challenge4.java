package dev.val;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dev.val")
public class Challenge4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(Challenge4.class);

        CommandHospitalService commandHospitalService = context.getBean(CommandHospitalService.class);

        System.out.println("*********************************************");
        System.out.println("Welcome to this  Hospital Registration Portal");
        System.out.println("*********************************************");

        while(true){
            System.out.print("Enter a command (register, report or exit): ");

            String command = scanner.nextLine().toLowerCase().trim();

            if(command.equals("exit")){
                scanner.close();
                ((AnnotationConfigApplicationContext)context).close();
                break;
            }

            commandHospitalService.executeHospitalCommand(command);
        }
    }
}