package org.example.dao.repository.root;

import org.example.dao.Helper.DaoHelper;
import org.example.dao.database.mysql.MySqlConnection;
import org.example.dao.database.quiry.SqlQueries;

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

    public ResultSet save(T model) {
        try {
            String[][] fields = DaoHelper.getClassFields(modelClass);
            String[] values = DaoHelper.getClassValues(model);
            String query = SqlQueries.insertInto(tableName, fields, values);
            this.statement.execute(query, Statement.RETURN_GENERATED_KEYS);

            resultSet = statement.getGeneratedKeys();
            resultSet.next();

            int generatedId = resultSet.getInt(1);


            resultSet.close(); fields = null;values = null;query = null;

            return this.findOrThrow(generatedId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ResultSet update(T model, int id) {
        try {
            this.findOrThrow(id);
            String[][] fields = DaoHelper.getClassFields(modelClass);
            String[] values = DaoHelper.getClassValues(model);
            String query = SqlQueries.update(tableName, fields, values, id);
            this.statement.execute(query);
            return this.findOrThrow(id);
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

