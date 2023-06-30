package ru.smartjava.service;

import org.springframework.stereotype.Service;
import ru.smartjava.exception.NotFoundException;
import ru.smartjava.model.Post;
import ru.smartjava.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        if (post.getId() > 0) repository.getById(post.getId()).orElseThrow(NotFoundException::new);
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.getById(id).orElseThrow(NotFoundException::new);
        repository.removeById(id);
    }
}

