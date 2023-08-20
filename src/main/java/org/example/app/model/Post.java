package org.example.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Post extends BaseModel<Post>{

    public int id;
    public String title;
    public String content;


    @Override
    public Post setData(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Post> setDataList(ResultSet resultSet) throws SQLException {
        return null;
    }
}
