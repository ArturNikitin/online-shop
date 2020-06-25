package repository.impl;

import model.Product;
import model.UneatableProduct;
import repository.JdbcUtils;
import repository.WarehouseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WarehouseRepositoryImpl implements WarehouseRepository {
    @Override
    public int getStockValue(Product product) {
        int result = 0;
        PreparedStatement statement = null;
        try (Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM products p " +
                    "INNER JOIN warehouse w ON p.id = w.product_id " +
                    "WHERE p.id = (?)");
            statement.setInt(1, product.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               result = resultSet.getInt("stock_value");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
    * Decreases stock value by 1
    * */
    @Override
    public void updateStockValue(Product product) {
        PreparedStatement statement = null;
        try(Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("UPDATE warehouse " +
                    "SET stock_value = (SELECT stock_value FROM warehouse WHERE product_id = (?)) -1 " +
                    "WHERE product_id = (?)");
            statement.setInt(1, product.getId());
            statement.setInt(2, product.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStockValue(Product product, int stockValue) {
        PreparedStatement statement = null;
        try(Connection connection = JdbcUtils.getConnection()) {
            statement = connection.prepareStatement("UPDATE warehouse " +
                    "SET stock_value = (?) " +
                    "WHERE product_id = (?)");
            statement.setInt(1, stockValue);
            statement.setInt(2, product.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
