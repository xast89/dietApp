package pl.gondek.dietapplication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;
import pl.gondek.dietapplication.repository.SecurityRepository;
import pl.gondek.dietapplication.repository.UserRepository;
import pl.gondek.dietapplication.session.MySessionScope;

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
        String providedPassword = security.getPassword();
        Security securityFromDB = securityRepository.findByLogin(security.getLogin());

        if (securityFromDB != null)
        {
            User user = userRepository.findBySecurity_Id(securityFromDB.getId());

            String passwordFromDB = securityFromDB.getPassword();
            String saltFromDB = securityFromDB.getSalt();

            if (PasswordUtils.verifyUserPassword(providedPassword, passwordFromDB, saltFromDB))
            {
                //TODO: usunac to.
//                context.setCurrentUser(user);
                mySessionScope.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }
}
