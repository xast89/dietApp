package pl.tbs.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tbs.fitapp.model.Security;
import pl.tbs.fitapp.processor.SignUpProcessor;

@Controller
public class SignUpController {

    @Autowired
    private SignUpProcessor signUpProcessor;

    @GetMapping("/signUp")
    public String signUpGet(Model model)
    {
        model.addAttribute("security", new Security());

        return "registerAndLogin/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@ModelAttribute Security security, Model model)
    {
        model.addAttribute("user", new Security());

        return signUpProcessor.signUp(security);
    }

}
