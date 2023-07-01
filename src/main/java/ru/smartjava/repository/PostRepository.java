package ru.smartjava.repository;

import ru.smartjava.model.Post;

import java.util.List;
import java.util.Optional;

// Stub
public interface PostRepository {

    List<Post> all();

    Optional<Post> getById(long id);

    Optional<Post> save(Post post);

    void removeById(long id);
}
