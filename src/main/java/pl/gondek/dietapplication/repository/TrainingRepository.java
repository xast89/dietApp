package pl.gondek.dietapplication.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gondek.dietapplication.model.Training;

public interface TrainingRepository extends CrudRepository<Training, Long> {
}
