package web.repository;

import org.springframework.stereotype.Repository;
import web.entities.User;

import java.util.List;

@Repository
public interface UserRepository {

    void saveUser(User user);

    User loadUser(long id);

    void removeUserById(long id);

    List<User> loadAllUsers();

    void changeUser(User user);

}
