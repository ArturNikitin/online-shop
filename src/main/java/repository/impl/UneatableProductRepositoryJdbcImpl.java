package repository.impl;

import model.EatableProduct;
import model.Product;
import model.UneatableProduct;
import repository.JdbcUtils;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UneatableProductRepositoryJdbcImpl implements ProductRepository {
    @Override
    public Set<UneatableProduct> getAllProducts() {
        Set<UneatableProduct> uneatableProducts = new HashSet<>();

        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN uneatable_products u ON p.id = u.product_id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                uneatableProducts.add(new UneatableProduct(resultSet.getInt("id"), resultSet.getDouble("price"),
                        resultSet.getString("name")));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return uneatableProducts;
    }

    @Override
    public UneatableProduct addProduct(Product product) {
        return null;
    }

    @Override
    public UneatableProduct getProductById(int id) {
        UneatableProduct product = null;
        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN uneatable_products u ON p.id = u.product_id " +
                    "WHERE p.id = (?)");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = new UneatableProduct(resultSet.getInt("id"), resultSet.getDouble("price"),
                        resultSet.getString("name"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
