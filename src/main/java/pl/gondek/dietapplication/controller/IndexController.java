package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.defaults.FoodList;
import pl.gondek.dietapplication.defaults.ReactionList;
import pl.gondek.dietapplication.model.Incident;
import pl.gondek.dietapplication.model.Meal;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.IncidentRepository;
import pl.gondek.dietapplication.repository.MealRepository;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.utils.AllergensFinder;
import pl.gondek.dietapplication.utils.Context;

import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private AllergensFinder allergensFinder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Context context;

    @GetMapping(value = {"", "/"})
    public String login(Model model)
    {
        model.addAttribute("user", new Security());

        return "index";
    }

    @PostMapping()
    public String loginPost(@ModelAttribute() User userForRegister)
    {

//        User userForLogin = userRepository.findByUsernameAndPassword(userForRegister.getUsername(), userForRegister.getSecurity().getPassword());

//        if(userForLogin != null)
        if (true)
        {
            return "menu";
        } else
        {
            return "login";
        }

    }

//    @GetMapping("/webjars")
//    public String logIn()
//    {
//        return "redirect:/menu";
//    }

}
