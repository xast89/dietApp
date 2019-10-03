package pl.gondek.dietapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gondek.dietapplication.model.Security;

@Controller
public class IndexController {

    @GetMapping(value = {"", "/"})
    public String login(Model model)
    {
        model.addAttribute("user", new Security());

        return "index";
    }
}
