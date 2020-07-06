package repository.impl;

import model.Cart;
import model.Product;
import model.User;
import repository.CartRepository;
import repository.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CartRepositoryJdbcImpl implements CartRepository {

    @Override
    public Cart getCartByUser(User user) {
        Cart cart = null;
        Map<Integer, Integer> productsById = new HashMap<>();
        PreparedStatement statement = null;
        try(Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM cart " +
                    "INNER JOIN users u on cart.cart_id = u.id " +
                    "INNER JOIN products p on cart.product_id = p.id " +
                    "WHERE u.id = (?)");
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            cart = new Cart();
            cart.setId(user.getId());
            while (resultSet.next()) {
               productsById.put(resultSet.getInt("product_id"), resultSet.getInt("product_amount"));
            }
            cart.setProducts(productsById);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public void addProduct(User user, Product product, int amount) {
        PreparedStatement statement = null;
        try(Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("INSERT INTO cart VALUES ((?), (?), (?))");
            statement.setInt(1,user.getId());
            statement.setInt(2,product.getId());
            statement.setInt(3,amount);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
