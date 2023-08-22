package org.example.app.repository;

import org.example.app.model.Category;
import org.example.dao.ORM.BaseRepository;

public class CategoryRepository extends BaseRepository<Category> {
    public CategoryRepository() {
        super(Category.class);
    }
}
