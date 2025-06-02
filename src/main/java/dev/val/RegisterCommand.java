package dev.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Scanner;

@Component
public class RegisterCommand implements HospitalCommand {

    @Autowired
    VisitService visitService;

    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Doctor? A or B: ");
        String doctor = scanner.nextLine().trim();

        Visit visit = new Visit(name, lastName, doctor.isEmpty() ? "a patient" : doctor, LocalDateTime.now());
        visitService.addVisit(visit);
        System.out.println("Visit registered.\n");
    }
    @Override
    public String getName(){
        return "register";
    }
}