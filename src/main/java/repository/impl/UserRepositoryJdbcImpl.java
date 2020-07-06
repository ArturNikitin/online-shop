package repository.impl;

import model.User;
import repository.JdbcUtils;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryJdbcImpl implements UserRepository {
    @Override
    public User getUserById(int id) {
        User user = null;
        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM users " +
                    "WHERE id = (?)");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM users " +
                    "WHERE name = (?)");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
