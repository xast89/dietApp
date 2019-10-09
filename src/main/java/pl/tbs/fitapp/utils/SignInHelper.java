package pl.tbs.fitapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tbs.fitapp.model.Security;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.repository.SecurityRepository;
import pl.tbs.fitapp.repository.UserRepository;
import pl.tbs.fitapp.session.MySessionScope;

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
