package ru.smartjava.utils;

import ru.smartjava.exception.NotFoundException;
import ru.smartjava.model.Post;
import ru.smartjava.model.PostDto;

public class Converter {

    public static PostDto modelToDto(Post post) {
        if(post.isActive()) {
            return new PostDto(post.getId(), post.getContent());
        }
        throw new NotFoundException();
    }
    public static Post dtoToModel(PostDto postDto) {
        return new Post(postDto.getId(), postDto.getContent(), false);
    }
}
