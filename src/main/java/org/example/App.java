package org.example;

import org.example.app.service.CategoryService;
import org.example.dao.Helper.PrintHelper;


import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        CategoryService categoryService = new CategoryService();
        PrintHelper.printClassList(categoryService.findAll());

    }

}
