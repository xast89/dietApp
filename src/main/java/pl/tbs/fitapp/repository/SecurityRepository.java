package pl.tbs.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbs.fitapp.model.Security;

public interface SecurityRepository extends JpaRepository<Security, Long> {

    Security findByLogin(String login);
//
//    User findByUsernameAndPassword(String username, String password);
}