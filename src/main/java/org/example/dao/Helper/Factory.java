package org.example.dao.Helper;

import org.example.dao.Type.Paragraph;
import org.example.dao.Type.Text;
import org.example.dao.database.connection.Config;
import org.example.dao.database.quiry.MysqlQueries;
import org.example.dao.database.quiry.PostgresqlQueries;
import org.example.dao.database.quiry.SqlQueries;

public class Factory {
    private static Text tempText = new Text();
    private static Paragraph tempParagraph = new Paragraph();

    private static SqlQueries sqlQueries;

    public static Text createNewText() {
        tempText = null;
        tempText = new Text();
        return tempText;
    }

    public static Paragraph createNewParagraph() {
        tempParagraph = null;
        tempParagraph = new Paragraph();
        return tempParagraph;
    }

    public static Object createSpecialFieldValue(Class<?> fieldType, String value) {
        if (fieldType.equals(Text.class)) return createNewText().set(value);
        else if (fieldType.equals(Paragraph.class)) return createNewParagraph().set(value);
        else throw new IllegalArgumentException("Invalid special field type");
    }


    public static SqlQueries getSqlQueries() {
        if(sqlQueries != null) return sqlQueries;
        if(Config.DATABASE_TYPE.equals("postgresql")) {
            sqlQueries = new PostgresqlQueries();
        } else if(Config.DATABASE_TYPE.equals("mysql")) {
            sqlQueries = new MysqlQueries();
        } else {
            throw new IllegalArgumentException("Unsupported database type: " + Config.DATABASE_TYPE);
        }
        return sqlQueries;
    }

}
