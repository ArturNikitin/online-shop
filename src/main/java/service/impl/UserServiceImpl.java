package service.impl;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryJdbcImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository repository = new UserRepositoryJdbcImpl();
    @Override
    public boolean validateUser(String name, String password) {
        User user = repository.getUserByName(name);
        return user != null && user.getPassword().equals(password);
    }
}
