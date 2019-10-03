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
import pl.gondek.dietapplication.session.MySessionScope;
import pl.gondek.dietapplication.utils.AllergensFinder;
import pl.gondek.dietapplication.utils.Context;

import java.util.List;
import java.util.Set;

@Controller
public class UserPanelController {

    @Autowired
    private MySessionScope mySessionScope;

    @GetMapping("addPersonalData")
    public String addPersonalData(Model model)
    {
        model.addAttribute("user", new User());

        return "signIn/addPersonalData";
    }

    @PostMapping("addPersonalData")
    public String loginPost(@ModelAttribute() User userForRegister, Model model)
    {

//        User userForLogin = userRepository.findByUsernameAndPassword(userForRegister.getUsername(), userForRegister.getSecurity().getPassword());

//        if(userForLogin != null)
        if (true)
        {
            model.addAttribute("session222222", mySessionScope.getMyValue());
            return "menu";
        } else
        {
            return "login";
        }

    }

}
