package Animals.first.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AnimalDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/Animals";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ZAQ!2wsx";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
