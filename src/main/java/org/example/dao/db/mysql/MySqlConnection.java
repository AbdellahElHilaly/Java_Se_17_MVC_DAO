package org.example.dao.db.mysql;

import org.example.app.Helper.PrintHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "jdbc_posts_java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private MySqlConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection();
        }
        return connection;
    }

    private synchronized static void initializeConnection() throws SQLException {
        PrintHelper.printInfoMessage("Connecting to database " + DATABASE + "...................................");
        connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);
        PrintHelper.printSuccessMessage("Connected to database " + DATABASE + " successfully");
    }


    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
