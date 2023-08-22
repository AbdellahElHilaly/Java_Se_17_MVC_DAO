package org.example.app.model;


import org.example.dao.ORM.ModelMapper;
import org.example.dao.Type.Text;

public class Post extends ModelMapper<Post> {

    public int id;
    public String title;
    public Text content;



    @Override
    public Post createInstance() {
        return new Post();
    }
}
