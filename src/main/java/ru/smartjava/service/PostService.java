package ru.smartjava.service;

import org.springframework.stereotype.Service;
import ru.smartjava.exception.NotFoundException;
import ru.smartjava.model.Post;
import ru.smartjava.model.PostDto;
import ru.smartjava.repository.PostRepository;
import ru.smartjava.utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<PostDto> all() {
        return repository.all().stream().filter(Post::isActive).map(Converter::modelToDto).collect(Collectors.toList());
    }

    public PostDto getById(long id) {
        return Converter.modelToDto(repository.getById(id).orElseThrow(NotFoundException::new));
    }

    public PostDto save(PostDto postDto) {
        if (postDto.getId() > 0) getById(postDto.getId());
        return Converter.modelToDto(repository.save(Converter.dtoToModel(postDto)).orElseThrow(NotFoundException::new));
    }

    public void removeById(long id) {
        getById(id);
        repository.removeById(id);
    }

    public List<Post> deleted() {
        return repository.all().stream().filter(Post::getDeleted).collect(Collectors.toList());
    }
}

