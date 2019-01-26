package pl.gondek.dietapplication.utils;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.UserRepository;

@Component
public class SignInHelper {


    public boolean shouldBeLogged(UserRepository userRepository, User user)
    {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
    }


}
