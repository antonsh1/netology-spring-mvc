package ru.smartjava.controller;

import org.springframework.web.bind.annotation.*;
import ru.smartjava.model.Post;
import ru.smartjava.model.PostDto;
import ru.smartjava.service.PostService;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostDto> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/deleted")
    public List<Post> getDeleted() {
        return service.deleted();
    }
    @PostMapping
    public PostDto save(@RequestBody PostDto postDto) {
        return service.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) {
        service.removeById(id);
    }
}
