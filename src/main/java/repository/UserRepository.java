package repository;

import model.User;

public interface UserRepository {
    User getUserById(int id);

    User getUserByName(String name);
}
