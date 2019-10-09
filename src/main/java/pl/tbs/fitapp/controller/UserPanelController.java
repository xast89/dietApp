package pl.tbs.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tbs.fitapp.model.Training;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.repository.TrainingRepository;
import pl.tbs.fitapp.repository.UserRepository;
import pl.tbs.fitapp.session.MySessionScope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Controller
public class UserPanelController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MySessionScope mySessionScope;
    @Autowired
    private TrainingRepository trainingRepository;

    @GetMapping("addPersonalData")
    public String addPersonalData(Model model)
    {
        model.addAttribute("user", new User());

        return "signIn/addPersonalData";
    }

    @PostMapping("addPersonalData")
    public String addPersonalDataPost(@ModelAttribute User userWithUpdatedInfo)
    {
        User currentUser = mySessionScope.getCurrentUser();
        updateUserProperties(userWithUpdatedInfo, currentUser);

        userRepository.save(currentUser);

        return "signIn/userPage";
    }

    @GetMapping("createTraining")
    public String createTraining(Model model)
    {
        model.addAttribute("training", new Training());

        return "signIn/createTraining";
    }

    @PostMapping("createTraining")
    public String createTrainingPost(@ModelAttribute Training training)
    {
        User currentUser = userRepository.findById(mySessionScope.getCurrentUser().getId()).get();
        addRequiredInfo(training, currentUser);
        removeTrainingFromSameDay(training, currentUser);
        currentUser.getTraining().add(training);
        userRepository.save(currentUser);

        return "signIn/userPage";
    }

    private void addRequiredInfo(@ModelAttribute Training training, User currentUser)
    {
        training.setUser(currentUser);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        training.setDate(sdf.format(new Date()));
    }

    private void removeTrainingFromSameDay(@ModelAttribute Training training, User currentUser)
    {
        currentUser.getTraining().stream()
                .filter(tr -> tr.getDate().equalsIgnoreCase(training.getDate()))
                .findFirst().ifPresent(value -> currentUser.getTraining().remove(value));
    }

    private void updateUserProperties(@ModelAttribute User userWithUpdatedInfo, User currentUser)
    {
        if (userWithUpdatedInfo.getAge() > 10)
        {
            currentUser.setAge(userWithUpdatedInfo.getAge());
        }
        if (!Objects.nonNull(userWithUpdatedInfo.getGender()))
        {
            currentUser.setGender(userWithUpdatedInfo.getGender());
        }
        if (userWithUpdatedInfo.getHeight() > 120)
        {
            currentUser.setHeight(userWithUpdatedInfo.getHeight());
        }
        if (Objects.nonNull(userWithUpdatedInfo.getName()))
        {
            currentUser.setName(userWithUpdatedInfo.getName());
        }
        if (userWithUpdatedInfo.getWeight() > 30)
        {
            currentUser.setWeight(userWithUpdatedInfo.getWeight());
        }
    }
}
