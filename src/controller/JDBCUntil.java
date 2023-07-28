package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUntil {
    public static Connection getConnection() {
        Connection c = null;
        try {
            String url = "jdbc:mySQL://localhost:3306/bookstoredb";
            String username = "root";
            String password = "123456";
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
