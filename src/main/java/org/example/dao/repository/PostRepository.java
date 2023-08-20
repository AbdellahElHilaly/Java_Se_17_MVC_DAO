package org.example.dao.repository;

import org.example.app.model.Post;
import org.example.dao.repository.root.BaseRepository;

public class PostRepository extends BaseRepository<Post> {


    public PostRepository(Post model) {
        super(Post.class);
    }
}
