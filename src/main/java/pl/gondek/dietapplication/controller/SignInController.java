package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.utils.Context;
import pl.gondek.dietapplication.utils.SignInHelper;

@Controller
public class SignInController {

    @Autowired
    private SignInHelper signInHelper;

    @PostMapping("/signIn")
    public String signInPost(@ModelAttribute Security userForLogin, Model model)
    {
        if (signInHelper.shouldBeLogged(userForLogin))
        {
            return "signIn/userPage";
        } else
        {
            model.addAttribute("user", new Security());
            return "registerAndLogin/login";
        }
    }
}
