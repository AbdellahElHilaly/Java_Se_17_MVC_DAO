package org.example.app.repository;

import org.example.app.model.Post;
import org.example.dao.ORM.BaseRepository;

public class PostRepository extends BaseRepository<Post> {

    public PostRepository() {
        super(Post.class);
    }

}
