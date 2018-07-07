package pl.gondek.dietapplication.repository;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Meal;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemporaryMealRepository {

    private List<Meal> meals = new ArrayList<>();


    public List<Meal> getMeals() {
        return meals;
    }

    public void addMeal(Meal meal)
    {
        meals.add(meal);
    }
}
