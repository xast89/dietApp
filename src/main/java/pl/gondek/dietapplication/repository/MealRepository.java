package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {


}
