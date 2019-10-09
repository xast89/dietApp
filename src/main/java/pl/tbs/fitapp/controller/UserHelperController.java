package pl.tbs.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tbs.fitapp.model.Training;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.repository.UserRepository;
import pl.tbs.fitapp.session.MySessionScope;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class UserHelperController {

    @Autowired
    private MySessionScope mySessionScope;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("trainingInfo")
    public String addPersonalData(Model model)
    {
        User user = userRepository.findById(mySessionScope.getCurrentUser().getId()).get();

        Training training = user.getTraining().stream()
                .max(this::compareDate).orElse(new Training());

        model.addAttribute("training", training);

        return "signIn/trainingInfo";
    }

    private int compareDate(Training o1, Training o2)
    {
        try
        {
            Date o1_date = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getDate());
            Date o2_date = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getDate());

            return o1_date.after(o2_date) ? 1 : -1;
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return 0;



    }
}
