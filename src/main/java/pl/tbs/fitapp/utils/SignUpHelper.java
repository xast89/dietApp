package pl.tbs.fitapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tbs.fitapp.model.Security;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.repository.SecurityRepository;
import pl.tbs.fitapp.repository.UserRepository;

@Component
public class SignUpHelper {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private UserRepository userRepository;

    public User getSecurityByLogin(String login)
    {
        Security byLogin = securityRepository.findByLogin(login);
        User user = null;

        if (byLogin != null)
        {
            user = userRepository.findBySecurity_Id(Long.valueOf(byLogin.getId()));
        }
        return user;

    }

    public void register(Security userToSignUp)
    {
        User user = new User();

        user.setSecurity(userToSignUp);

        userRepository.save(user);
    }
}
