package dev.val;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    private List<Visit> visits = new ArrayList<>();

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        return visits;
    }
}