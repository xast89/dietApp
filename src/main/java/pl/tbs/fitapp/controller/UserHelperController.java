package pl.tbs.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.session.MySessionScope;

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
