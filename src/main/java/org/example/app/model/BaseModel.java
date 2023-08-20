package org.example.app.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseModel<T> {
    protected List<T> dataList = new ArrayList<>();
    public abstract T setData(ResultSet resultSet) throws java.sql.SQLException;
    public abstract List<T> setDataList(ResultSet resultSet) throws java.sql.SQLException;
}
