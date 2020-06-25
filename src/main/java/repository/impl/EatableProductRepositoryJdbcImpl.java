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

public class EatableProductRepositoryJdbcImpl implements ProductRepository {

    @Override
    public Set<EatableProduct> getAllProducts() {
        Set<EatableProduct> eatableProducts = new HashSet<>();

        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN eatable_products e ON p.id = e.product_id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                eatableProducts.add(new EatableProduct(resultSet.getInt("id"), resultSet.getDouble("price"),
                        resultSet.getString("name"),
                        resultSet.getDouble("weight")));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eatableProducts;
    }

    @Override
    public EatableProduct addProduct(Product product) {
        return null;
    }

    @Override
    public EatableProduct getProductById(int id) {
        EatableProduct product = null;
        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN eatable_products e ON p.id = e.product_id " +
                    "WHERE p.id = (?)");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = new EatableProduct(resultSet.getInt("id"), resultSet.getDouble("price"),
                        resultSet.getString("name"),
                        resultSet.getDouble("weight"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
