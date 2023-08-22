package org.example.dao.Helper;

public class SqlHelper {
    public static String handelBoolenData(String value) {
        if (value.equals("true")) return "1";
        if (value.equals("false")) return "0";
        return value;
    }
}
