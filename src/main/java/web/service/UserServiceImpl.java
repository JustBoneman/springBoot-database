package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.entities.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void removeUser(long id) {
        userRepository.removeUserById(id);
    }

    @Override
    public void changeUser(User user) {
        userRepository.changeUser(user);
    }

    @Override
    public User loadUser(long id) {
        return userRepository.loadUser(id);
    }

    @Override
    public List<User> loadAllUsers() {
        return userRepository.loadAllUsers();
    }
}
