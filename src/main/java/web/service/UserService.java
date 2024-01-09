package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.entities.User;

import java.util.List;

@Service
@Transactional
public interface UserService {
    void saveUser(User user);

    void removeUser(long id);

    void changeUser(User user);

    User loadUser(long id);

    List<User> loadAllUsers();
}
