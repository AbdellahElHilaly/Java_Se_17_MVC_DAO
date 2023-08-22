package org.example.dao.database.quiry;


public class MysqlQueries extends SqlQueries {
    @Override
    public String createEmptyTable(String tableName) {
        return "CREATE TABLE IF NOT EXISTS " + tableName + " (id INT PRIMARY KEY AUTO_INCREMENT)";
    }


}
