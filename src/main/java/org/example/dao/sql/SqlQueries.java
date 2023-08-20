package org.example.dao.sql;

public class SqlQueries {
    public static String createEmptyTable(String tableName) {
        return "CREATE TABLE IF NOT EXISTS " + tableName + " (id INT PRIMARY KEY AUTO_INCREMENT)";
    }

    public static String addIntColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " INT";
    }

    public static String addDoubleColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " DOUBLE";
    }

    public static String addStringColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " VARCHAR(255)";
    }

    public static String addBooleanColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " BOOLEAN";
    }

    public static String addDateColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " DATE";
    }

    public static String addTimeColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " TIME";
    }

    public static String addDateTimeColumnIfNotExists(String tableName, String columnName) {
        return "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " + columnName + " DATETIME";
    }

    public static String selectAll(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String selectById(String tableName, int id) {
        return "SELECT * FROM " + tableName + " WHERE id = " + id;
    }

    public static String deleteById(String tableName, int id) {
        return "DELETE FROM " + tableName + " WHERE id = " + id;
    }
}
