package org.example.app.service;

import org.example.app.model.User;
import org.example.dao.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    User user = new User();

    UserRepository userRepository = new UserRepository(user);

    public User find(int id) throws SQLException {
        return user.setData(userRepository.find(id));
    }

    public List<User> findAll() throws SQLException {
        return user.setDataList(userRepository.findAll());
    }

    public void delete(int id) throws SQLException {
        userRepository.delete(id);
    }


}
