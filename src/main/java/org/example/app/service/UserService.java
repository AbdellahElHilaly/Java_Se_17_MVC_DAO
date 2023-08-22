package org.example.app.service;

import org.example.app.model.User;
import org.example.app.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    User user = new User();

    UserRepository userRepository = new UserRepository();

    public User find(int id) throws SQLException {
        return user.mapData(userRepository.find(id));
    }

    public List<User> findAll() throws SQLException {
        return user.mapDataList(userRepository.findAll());
    }

    public void delete(int id) throws SQLException {
        userRepository.delete(id);
    }

    public  User save(User user)throws SQLException{
        return  this.user.mapData(userRepository.save(user));
    }

    public  User update(User user, int id) throws SQLException {
        return  this.user.mapData(userRepository.update(user, id));
    }


}
