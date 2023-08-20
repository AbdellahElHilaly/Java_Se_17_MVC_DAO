package org.example.app.model;

import java.sql.ResultSet;
import java.util.List;

public interface BaseModel<T> {
    public T setData(ResultSet resultSet) throws java.sql.SQLException;
    public List<T> setDataList(ResultSet resultSet) throws java.sql.SQLException;
}
