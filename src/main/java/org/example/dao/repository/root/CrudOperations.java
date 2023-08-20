package org.example.dao.repository.root;

import org.example.dao.Helper.DaoHelper;
import org.example.dao.db.mysql.MySqlConnection;
import org.example.dao.sql.SqlQueries;

import java.sql.*;


public class CrudOperations<T> {

    protected final Class<T> modelClass;
    protected final String tableName;
    protected Connection connection;
    protected Statement statement;
    ResultSet resultSet;

    public CrudOperations(Class<T> modelClass) {
        this.modelClass = modelClass;
        this.tableName = DaoHelper.getTableName(modelClass);
        try {
            this.connection = MySqlConnection.getConnection();
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet find(int id) {
        try {
            return this.findOrThrow(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet findAll() {
        try {
            return this.statement.executeQuery(SqlQueries.selectAll(tableName));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            this.findOrThrow(id);
            this.statement.execute(SqlQueries.deleteById(tableName, id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet findOrThrow(int id) throws SQLException {
        resultSet = this.statement.executeQuery(SqlQueries.selectById(tableName, id));
        if(!resultSet.next())   throw new RuntimeException("No such id: " +id + " in table: " + tableName);
        return resultSet;
    }
}

