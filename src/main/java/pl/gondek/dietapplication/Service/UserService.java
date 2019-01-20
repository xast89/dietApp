package pl.gondek.dietapplication.Service;

import pl.gondek.dietapplication.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
