package pl.gondek.dietapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gondek.dietapplication.model.BaseEntity;
import pl.gondek.dietapplication.model.Training;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.TrainingRepository;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.session.MySessionScope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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
        User currentUser2 = mySessionScope.getCurrentUser();
        User currentUser = userRepository.findById(currentUser2.getId()).get();

        training.setUser(currentUser);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        training.setDate(sdf.format(new Date()));


        Optional<Training> oldTrainingFromSameDate = currentUser.getTraining().stream()
                .filter(tr -> tr.getDate().equalsIgnoreCase(training.getDate()))
                .findFirst();

//        oldTrainingFromSameDate.ifPresent(value -> trainingRepository.deleteById(value.getId()));

        if(oldTrainingFromSameDate.isPresent())
        {
            trainingRepository.deleteById(oldTrainingFromSameDate.get().getId());
            currentUser.getTraining().remove(oldTrainingFromSameDate.get());
        }

        currentUser.getTraining().add(training);
//        trainingRepository.save(training);
        userRepository.saveAndFlush(currentUser);

        return "signIn/userPage";
    }

//    @GetMapping("delete")
//    public String deleteTraining(Model model)
//    {
//
//        User currentUser = mySessionScope.getCurrentUser();
//        currentUser.getTraining().remove(1L);
//
//        userRepository.saveAndFlush(currentUser);
//
//        return "signIn/userPage";
//    }

    private void updateUserProperties(@ModelAttribute User userWithUpdatedInfo, User currentUser)
    {
        if(userWithUpdatedInfo.getAge() > 10)
        {
            currentUser.setAge(userWithUpdatedInfo.getAge());
        }
        if(!Objects.nonNull(userWithUpdatedInfo.getGender()))
        {
            currentUser.setGender(userWithUpdatedInfo.getGender());
        }
        if(userWithUpdatedInfo.getHeight() > 120)
        {
            currentUser.setHeight(userWithUpdatedInfo.getHeight());
        }
        if(Objects.nonNull(userWithUpdatedInfo.getName()))
        {
            currentUser.setName(userWithUpdatedInfo.getName());
        }
        if(userWithUpdatedInfo.getWeight() > 30)
        {
            currentUser.setWeight(userWithUpdatedInfo.getWeight());
        }
    }
}
