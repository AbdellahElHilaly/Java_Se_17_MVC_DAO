package org.example.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User extends BaseModel<User> {
    public int id;
    public String name;
    public int age;
    public double salary;
    public boolean isMarried;


    @Override
    public User setData(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.name = resultSet.getString("name");
        this.age = resultSet.getInt("age");
        this.salary = resultSet.getDouble("salary");
        this.isMarried = resultSet.getBoolean("isMarried");
        return this;
    }

    @Override
    public List<User> setDataList(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            User user = new User();
            user.setData(resultSet);
            this.dataList.add(user);
        }

        return this.dataList;
    }

}
