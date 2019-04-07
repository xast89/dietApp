package pl.gondek.dietapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gondek.dietapplication.model.Security;
import pl.gondek.dietapplication.model.User;

public interface SecurityRepository extends JpaRepository<Security, Long> {

    Security findByLogin(String login);
//
//    User findByUsernameAndPassword(String username, String password);
}