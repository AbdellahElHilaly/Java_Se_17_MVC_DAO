package org.example.dao.database.quiry;

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

    public static String insertInto(String tableName, String[][] fields, String[] values) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(tableName).append(" (");
        for (String[] field : fields) {
            stringBuilder.append(field[1]).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(") VALUES (");
        for (String value : values) {
            if (value.equals("true")) {
                value = "1";
            } else if (value.equals("false")) {
                value = "0";
            }
            stringBuilder.append("'").append(value).append("'").append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String update(String tableName, String[][] fields, String[] values, int id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ").append(tableName).append(" SET ");

        for (int i = 0; i < fields.length; i++) {
            String field = fields[i][1];
            if (field.equals("id"))  continue;
            String value = values[i];

            if (value.equals("true")) {
                value = "1";
            } else if (value.equals("false")) {
                value = "0";
            }

            stringBuilder.append(field).append(" = '").append(value).append("'");

            if (i < fields.length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append(" WHERE id = ").append(id);

        return stringBuilder.toString();
    }

}
