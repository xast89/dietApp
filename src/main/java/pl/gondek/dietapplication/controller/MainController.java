package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.Service.UserServiceImpl;
import pl.gondek.dietapplication.defaults.FoodList;
import pl.gondek.dietapplication.defaults.ReactionList;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Meal;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.IncidentRepository;
import pl.gondek.dietapplication.repository.MealRepository;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.utils.AllergensFinder;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private AllergensFinder allergensFinder;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String login(Model model) {

        model.addAttribute("user", new User());

        return "registerAndLogin/login";
    }

    @PostMapping()
    public String loginPost(@ModelAttribute() User userForRegister) {

        User userForLogin = userRepository.findByUsernameAndPassword(userForRegister.getUsername(), userForRegister.getPassword());

        if(userForLogin != null)
        {
            return "menu";
        }
        else
        {
            return "login";
        }

    }

    @GetMapping("/webjars")
    public String logIn() {
        return "redirect:/menu";
    }

        @GetMapping("/addMeal")
    public String addMeal(Model model) {
        model.addAttribute("foods", new FoodList());
        model.addAttribute("meal", new Meal());

        return "addMeal";
    }

    @PostMapping(value = "/addMeal")
    public String addMeal(@ModelAttribute Meal meal, BindingResult errors, Model model) {

        mealRepository.save(meal);
        return "menu";
    }

    @GetMapping("/addReaction")
    public String addReaction(Model model) {
        model.addAttribute("reactions", new ReactionList());
        model.addAttribute("incident", new Incident());

        return "addReaction";
    }

    @PostMapping(value = "/addReaction")
    public String addReaction(@ModelAttribute Incident incident, BindingResult errors, Model model) {

        incidentRepository.save(incident);

        return "menu";
    }

    @GetMapping("/findAllergens")
    public String findAllergens(Model model) {

        List<Meal> allergens = allergensFinder.findAllergens(mealRepository, incidentRepository);

        model.addAttribute("reactions", new ReactionList());
        model.addAttribute("incident", new Incident());
        model.addAttribute("allergens", allergens);

        return "findAllergens";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }


}
