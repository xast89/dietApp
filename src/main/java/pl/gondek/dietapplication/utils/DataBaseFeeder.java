package pl.gondek.dietapplication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.processor.SignUpProcessor;

@Component
public class DataBaseFeeder {

    @Autowired
    private SignUpProcessor signUpProcessor;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        addUserToDatabase("admin", "admin");
        addUserToDatabase("sa", "sa");

    }

    private void addUserToDatabase(String login, String password)
    {
        Security security = new Security();
        security.setLogin(login);
        security.setPassword(password);
        signUpProcessor.signUp(security);
    }
}
