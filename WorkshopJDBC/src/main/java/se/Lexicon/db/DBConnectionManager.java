package se.Lexicon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class for managing database connection
public class DBConnectionManager {
    private static final String JDBC_USER = "root"; // Database username
    private static final String JDBC_PWD = "1234"; // Database password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/world"; // Database URL

    // Method to establish a database connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
        } catch (SQLException e) {
            // Handling database connection errors
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return connection;
    }
}
