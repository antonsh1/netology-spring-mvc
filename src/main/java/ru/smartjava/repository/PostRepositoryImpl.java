package ru.smartjava.repository;

import org.springframework.stereotype.Repository;
import ru.smartjava.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryImpl implements PostRepository {

    ConcurrentHashMap<Long, Post> repo = new ConcurrentHashMap<>();
    AtomicLong index = new AtomicLong(0);

    public List<Post> all() {
        return new ArrayList<>(repo.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(repo.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(index.addAndGet(1));
        }
        repo.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        repo.remove(id);
    }
}
