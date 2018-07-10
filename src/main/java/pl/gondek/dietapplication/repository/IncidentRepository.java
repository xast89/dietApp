package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
