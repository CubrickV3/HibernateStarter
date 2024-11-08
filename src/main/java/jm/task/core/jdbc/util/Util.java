package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatebase";
    private static final String USER = "root";
    private static final String PASSWORD = "gogol.2002";

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
}
