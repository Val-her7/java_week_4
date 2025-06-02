package dev.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportCommand implements HospitalCommand{

    @Autowired
    private VisitService visitService;

    @Override
    public void execute(){
        System.out.println("\n=== Visit Report ===");
        if (visitService.getVisits().isEmpty()) {
            System.out.println("No visits recorded.");
        } else {
            visitService.getVisits().forEach(System.out::println);
        }
        System.out.println();
    }
    @Override
    public String getName(){
        return "report";
    }
}
