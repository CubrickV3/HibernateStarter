package jm.task.core.jdbc.util;

import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util implements AutoCloseable {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatebase";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public Util() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Could not connect to database\n" + e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
