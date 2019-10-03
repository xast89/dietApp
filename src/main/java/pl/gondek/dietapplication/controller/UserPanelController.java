package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.session.MySessionScope;

@Controller
public class UserPanelController {

    @GetMapping("addPersonalData")
    public String addPersonalData(Model model)
    {
        model.addAttribute("user", new User());

        return "signIn/addPersonalData";
    }
}
