package org.example.app.service;

import org.example.app.model.Category;
import org.example.app.repository.CategoryRepository;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    Category category = new Category();
    CategoryRepository categoryRepository = new CategoryRepository();

    public Category save(Category category) throws SQLException {
        return category.mapData(categoryRepository.save(category));
    }


    public List<Category> findAll() throws SQLException {
        return category.mapDataList(categoryRepository.findAll());
    }

    public Category find(int i) throws SQLException {
        return  category.mapData(categoryRepository.find(i));
    }

    public Category update(Category category, int i) throws SQLException {
        return category.mapData(categoryRepository.update(category, i));
    }
}
