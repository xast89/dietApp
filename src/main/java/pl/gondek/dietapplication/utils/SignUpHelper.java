package pl.gondek.dietapplication.utils;

import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.UserRepository;

@Component
public class SignUpHelper {


    public boolean shouldBeRegister(UserRepository userRepository, User user)
    {
        return userRepository.findByUsername(user.getUsername()) == null;
    }
}
