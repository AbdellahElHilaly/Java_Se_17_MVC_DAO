package org.example.dao.ORM;

import org.example.dao.Helper.DaoHelper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ModelMapper<T> {

    private T instance;
    private final List<T> dataList = new ArrayList<>();

    public T mapData(ResultSet resultSet) throws SQLException {
        instance = createInstance();

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            String columnName = rsmd.getColumnName(i);
            Object columnValue = resultSet.getObject(i);

            try {
                DaoHelper.setFieldByName(instance, columnName, columnValue); //pass instance by reference
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return instance;
    }

    public List<T> mapDataList(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            instance = createInstance();
            instance = mapData(resultSet);
            this.dataList.add(instance);
        }
        return this.dataList;
    }

    public abstract T createInstance();





}
