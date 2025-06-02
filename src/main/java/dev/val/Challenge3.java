package dev.val;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan("dev.val")
public class Challenge3 {
    public static void main( String[] args) {

        Scanner scanner =  new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(Challenge3.class);
        CommandService commandService = context.getBean(CommandService.class);

        System.out.println("*********************************");
        System.out.println("Welcome to this command line tool");
        
        while(true){
            System.out.print("Choose a command (hello, time or exit): ");

            String command = scanner.nextLine().toLowerCase().trim();

            if(command.equals("exit")){
                scanner.close();
                ((AnnotationConfigApplicationContext) context).close();
                break;
            }

            commandService.executeCommand(command);
        }
    }
}