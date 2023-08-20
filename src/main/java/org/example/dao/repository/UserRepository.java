package org.example.dao.repository;

import org.example.app.model.User;
import org.example.dao.repository.root.BaseRepository;

public class UserRepository extends BaseRepository<User> {


    public UserRepository(User model) {
        super(User.class);
    }
}
