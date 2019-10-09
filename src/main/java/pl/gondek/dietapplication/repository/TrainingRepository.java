package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    Training findByDate(String date);


}
