package pl.gondek.dietapplication.repository;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Incident;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemporaryIncidentRepository {

    private List<Incident> incidents = new ArrayList<>();

    public List<Incident> getIncidents() {

        return incidents;
    }

    public void addIncydent(Incident incident)
    {
        incidents.add(incident);
    }
}
