package pl.tbs.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbs.fitapp.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    Training findByDate(String date);


}
