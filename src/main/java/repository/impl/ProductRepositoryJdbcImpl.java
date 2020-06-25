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

public class ProductRepositoryJdbcImpl implements ProductRepository<Product> {
    @Override
    public Set<Product> getAllProducts() {
        Set<Product> products = new HashSet<>();

        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN uneatable_products u ON p.id = u.product_id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Hello!" + resultSet.getString("name"));
                products.add(new UneatableProduct(resultSet.getInt("id"), resultSet.getDouble("price"),
                        resultSet.getString("name")));
            }
            statement.close();

            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN eatable_products e ON p.id = e.product_id");
            ResultSet resultSet2 = statement.executeQuery();
            while (resultSet2.next()) {
                products.add(new EatableProduct(resultSet2.getInt("id"), resultSet2.getDouble("price"),
                        resultSet2.getString("name"),
                        resultSet2.getDouble("weight")));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
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

        if (product == null) {
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
        }
        return product;
    }
}
