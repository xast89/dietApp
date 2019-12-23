package pl.tbs.fitapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tbs.fitapp.model.Security;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.repository.SecurityRepository;
import pl.tbs.fitapp.repository.UserRepository;
import pl.tbs.fitapp.session.MySessionScope;

import java.util.Objects;

@Component
public class SignInHelper {

    @Autowired
    private SecurityRepository securityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MySessionScope mySessionScope;

    public boolean shouldBeLogged(Security security)
    {
        String passwordFromUser = security.getPassword();
        Security db_security = securityRepository.findByLogin(security.getLogin());

        if (Objects.nonNull(db_security))
        {
            User user = userRepository.findBySecurity_Id(db_security.getId());

            String passwordFromDB = db_security.getPassword();
            String saltFromDB = db_security.getSalt();

            if (PasswordUtils.isCorrectUserPassword(passwordFromUser, passwordFromDB, saltFromDB))
            {
                mySessionScope.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }
}
