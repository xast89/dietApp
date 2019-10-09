package pl.tbs.fitapp.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tbs.fitapp.model.Security;
import pl.tbs.fitapp.model.User;
import pl.tbs.fitapp.utils.PasswordUtils;
import pl.tbs.fitapp.utils.SignUpHelper;

import java.util.Objects;

@Component
public class SignUpProcessor {

    @Autowired
    private SignUpHelper signUpHelper;

    public String signUp(Security userToSignUp)
    {
        User security = signUpHelper.getSecurityByLogin(userToSignUp.getLogin());
        if (Objects.isNull(security))
        {
            String salt = PasswordUtils.getSalt(30);

            // Protect user's password. The generated value can be stored in DB.
            String mySecurePassword = PasswordUtils.generateSecurePassword(userToSignUp.getPassword(), salt);

            userToSignUp.setPassword(mySecurePassword);
            userToSignUp.setSalt(salt);

            signUpHelper.register(userToSignUp);
            return "registerAndLogin/login";
        } else
        {

            return "registerAndLogin/signUp";
        }
    }
}
