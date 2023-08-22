package org.example.dao.database.connection;

import org.example.dao.Helper.PrintHelper;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection extends Config{
    private static java.sql.Connection connection;
    private Connection() {

    }

    public static java.sql.Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection();
        }
        return connection;
    }

    private synchronized static void initializeConnection() throws SQLException {
        PrintHelper.printInfoMessage("Connecting to "+ DATABASE_TYPE +" database (name : " + DATABASE_NAME + ") ...................................");
        connection = DriverManager.getConnection("jdbc:"+DATABASE_TYPE+"://" + HOST + ":" + PORT + "/" + DATABASE_NAME, USERNAME, PASSWORD);
        PrintHelper.printSuccessMessage("Connected to to "+ DATABASE_TYPE +" database (name : " + DATABASE_NAME + ") successfully");
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
