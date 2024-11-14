package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
//    private static final String URL = "jdbc:postgresql://localhost:5432/Muramasa";
    private static final String USER = "postgres";
    private static final String PASSWORD = "081204";
    private static final String URL = System.getenv("DATABASE_URL");
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
