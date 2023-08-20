package org.example;

import org.example.app.Helper.PrintHelper;
import org.example.app.model.User;
import org.example.app.service.PostService;
import org.example.app.service.UserService;
import org.example.dao.repository.UserRepository;
import org.example.dao.repository.root.BaseRepository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {


        UserService userService = new UserService();


        List<User> users = userService.findAll();

        PrintHelper.printClassList(users);


    }



}
