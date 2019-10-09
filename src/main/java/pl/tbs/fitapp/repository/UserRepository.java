package pl.tbs.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbs.fitapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySecurity_Id(Long id);
//    User findBySecurity_SecurityId(long id);
//    User findBySecurityId(String id);
//    User findBySecurityId(long id);

//    User findBy(String username);
//
//    User findByUsernameAndPassword(String username, String password);
}