package org.example.app.model;


import org.example.dao.ORM.ModelMapper;

public class Post extends ModelMapper<Post> {

    public int id;
    public String title;
    public String content;


    @Override
    public Post createInstance() {
        return new Post();
    }
}
