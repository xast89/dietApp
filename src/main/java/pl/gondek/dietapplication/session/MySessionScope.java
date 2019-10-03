package pl.gondek.dietapplication.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySessionScope implements Serializable {

    private String myValue = "session scope " + String.valueOf(Math.random()).substring(0,10);

    public String getMyValue()
    {
        return myValue;
    }
}
