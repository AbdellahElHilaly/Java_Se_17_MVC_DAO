package org.example.dao.repository.root;

import org.example.app.Helper.PrintHelper;
import org.example.dao.Helper.DaoHelper;
import org.example.dao.database.quiry.SqlQueries;

import java.sql.SQLException;

public   class BaseRepository<T> extends CrudOperations<T> {

    public BaseRepository(Class<T> modelClass) {
        super(modelClass);
        try {
            this.createTable();
            this.addColumns();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createTable() throws SQLException {
        PrintHelper.printInfoMessage("Creating table " + tableName + "...................................");

        this.statement.execute(SqlQueries.createEmptyTable(tableName));

        PrintHelper.printSuccessMessage("Table " + tableName + " created successfully");
    }

    public void addColumns() throws SQLException {
        String[][] fields = DaoHelper.getClassFields(modelClass);
        for (String[] field : fields) {
            PrintHelper.printInfoMessage("Adding column " + field[1] + " to table " + tableName + "...................................");
            this.statement.execute(DaoHelper.getAddColumnQuery(tableName, field[0], field[1]));
            PrintHelper.printSuccessMessage("Column " + field[1] + " added successfully");
        }
        fields = null;

    }

}
