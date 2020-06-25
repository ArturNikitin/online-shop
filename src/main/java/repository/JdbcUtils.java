package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    private static final String USER = "postgres";
    private static final String PASSWORD = "1488";
    private static final String URL = "jdbc:postgresql://localhost:5432/online_shop";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
