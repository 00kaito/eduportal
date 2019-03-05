package com.jdev.eduportal.domains.user;

import com.jdev.eduportal.service.DbSecureRemover;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(String name, String email, String password) {
        User user;
        if (notNull(name, email, password)) {
            user = new User(name, email, password);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean createUser(User user) {
        return createUser(user.getName(), user.getEmail(), user.getPassword());
    }


    boolean notNull(String... args) {
        for (String arg : args) {
            if (null == arg || arg.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean removeUser(User user) {
        if (user != null && userRepository.findById(user.getId()).isPresent()) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean removeUserById(Long userId) {

        DbSecureRemover dbSecureRemover = new DbSecureRemover(userRepository);
        return dbSecureRemover.removeElementById(userId);
    }
}
