package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.utils.SignInHelper;
import pl.gondek.dietapplication.utils.SignUpHelper;

@Controller
public class RegisterAndLoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SignInHelper signInHelper;
    @Autowired
    private SignUpHelper signUpHelper;


    @GetMapping("/signUp")
    public String signUpGet(Model model) {

        model.addAttribute("user", new User());

        return "registerAndLogin/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@ModelAttribute User user)
    {

        if(signUpHelper.shouldBeRegister(userRepository, user))
        {
            //TODO: work around :) - delete setPasswordConfirm
            user.setPasswordConfirm(user.getPassword());
            userRepository.save(user);
            return "registerAndLogin/login";
        }
        else
        {
            return "registerAndLogin/signUp";
        }
    }

    @PostMapping("/signIn")
    public String signInPost(@ModelAttribute User user)
    {
        if(signInHelper.shouldBeLogged(userRepository, user))
        {
            return "signIn/userPage";
        }
        else
        {
            return "registerAndLogin/login";
        }

    }


}
