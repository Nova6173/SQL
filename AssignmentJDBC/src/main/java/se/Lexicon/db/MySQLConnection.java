package se.Lexicon.db;
import se.Lexicon.db.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Draken6173";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/todoit";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
