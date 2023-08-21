package org.example;

import org.example.app.Helper.PrintHelper;
import org.example.app.model.User;
import org.example.app.service.UserService;


import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();

//        PrintHelper.printClassList(userService.findAll());
//        PrintHelper.printClass(userService.find(4));
//        PrintHelper.printClass(userService.save(new User("abdellah", 22 , 37.89 , true)));
        PrintHelper.printClass(userService.update(new User("yesy", 22 , 37.89 , true), 4));


    }

}
