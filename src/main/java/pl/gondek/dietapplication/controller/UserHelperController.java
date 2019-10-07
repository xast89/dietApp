package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.model.Training;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.TrainingRepository;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.session.MySessionScope;

import java.util.Objects;

@Controller
public class UserHelperController {

    @Autowired
    private MySessionScope mySessionScope;

    @GetMapping("userInfo")
    public String addPersonalData(Model model)
    {
        User currentUser = mySessionScope.getCurrentUser();

        model.addAttribute("user", new User());

        return "signIn/addPersonalData";
    }
}
