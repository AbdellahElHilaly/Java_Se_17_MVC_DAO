package org.example.app.model;

import org.example.dao.ORM.ModelMapper;
import org.example.dao.Type.Text;


public class Category extends ModelMapper<Category> {
    private  int id;
    private  String name;

    private  String description;

    private Text content = new Text();

    public Category(String name, String description, String  content) {
        this.name = name;
        this.description = description;
        this.content.data = content;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Text getContent() {
        return content;
    }

    public Category() {

    }

    @Override
    public Category createInstance() {
        return new Category();
    }
}
