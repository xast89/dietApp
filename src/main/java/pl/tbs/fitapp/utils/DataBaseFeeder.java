package pl.tbs.fitapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.tbs.fitapp.model.Security;
import pl.tbs.fitapp.model.Training;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataBaseFeeder {

    @Autowired
    private UserRepository userRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        addUserToDatabase("admin", "admin");
        addUserToDatabase("sa", "sa");

    }

    private void addUserToDatabase(String login, String password)
    {
        User user = new User();

        Security security = new Security();
        security.setPassword(password);
        security.setLogin(login);
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(security.getPassword(), salt);
        security.setPassword(mySecurePassword);
        security.setSalt(salt);


        Set<Training> trainings = new HashSet<>();
        Training training = new Training();
        training.setAbbs(12);
        training.setLegs(22);
        training.setUser(user);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        training.setDate("08/10/2019");


        trainings.add(training);

        user.setSecurity(security);
        user.setTraining(trainings);

        userRepository.save(user);
    }
}
