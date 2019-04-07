package pl.gondek.dietapplication.utils;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Meal;
import pl.gondek.dietapplication.repository.IncidentRepository;
import pl.gondek.dietapplication.repository.MealRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllergensFinder {

    public List<Meal> findAllergens(MealRepository temporaryMealRepository, IncidentRepository incidentRepository)
    {
        List<Meal> results = new ArrayList<>();

        for (Meal meal : temporaryMealRepository.findAll())
        {

            for (Incident incident : incidentRepository.findAll())
            {

                if (incident.getStart().equals(meal.getStart()))
                {
                    results.add(meal);
                }
            }
        }

        return results;

//        temporaryMealRepository.getMeals().stream()
//                .peek(meal -> (temporaryIncydentRepository.getIncidents().stream().map(Incident::getStart).filter(date -> date.after(meal.getStart())));

//        temporaryMealRepository.getMeals().stream().map(Meal::getStart)
//                .filter(date -> (temporaryIncydentRepository.getIncidents().stream().map(Incident::getStart).filter(date -> date.equals(date)))

    }
}
