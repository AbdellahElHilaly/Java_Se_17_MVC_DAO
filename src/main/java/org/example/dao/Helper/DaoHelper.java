package org.example.dao.Helper;

import org.example.app.Helper.PrintHelper;
import org.example.dao.repository.root.BaseRepository;
import org.example.dao.repository.root.CrudOperations;
import org.example.dao.sql.SqlQueries;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DaoHelper {
    private static String className;

    public static String[][] getFields(Class<?> modelClass) {
        Field[] fields = modelClass.getDeclaredFields();
        List<String[]> filteredFields = new ArrayList<>();

        for (Field field : fields) {
            if (!field.isSynthetic()) { // Exclude synthetic fields
                String fieldType = field.getType().getSimpleName();
                String fieldName = field.getName();
                filteredFields.add(new String[]{fieldType, fieldName});
            }
        }

        return filteredFields.toArray(new String[0][0]);
    }

    public static  String getTableName(Class<?> modelClass) {

        String[] words = modelClass.getSimpleName().split("(?=\\p{Upper})");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word.toLowerCase()).append("_");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();

    }

    public static String getAddColumnQuery(String tableName, String dataType, String ColumnName) {
        switch (dataType) {
            case "String":
                return SqlQueries.addStringColumnIfNotExists(tableName, ColumnName);
            case "int":
                return SqlQueries.addIntColumnIfNotExists(tableName, ColumnName);
            case "double":
                return SqlQueries.addDoubleColumnIfNotExists(tableName, ColumnName);
            case "boolean":
                return SqlQueries.addBooleanColumnIfNotExists(tableName, ColumnName);
            case "Date":
                return SqlQueries.addDateColumnIfNotExists(tableName, ColumnName);
            case "Time":
                return SqlQueries.addTimeColumnIfNotExists(tableName, ColumnName);
            case "DateTime":
                return SqlQueries.addDateTimeColumnIfNotExists(tableName, ColumnName);
            default:
                PrintHelper.printErrorMessage("Unknown data type");
                return null;
        }
    }

}
