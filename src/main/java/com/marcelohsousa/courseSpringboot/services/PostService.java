package com.marcelohsousa.courseSpringboot.services;


import com.marcelohsousa.courseSpringboot.entities.Post;
import com.marcelohsousa.courseSpringboot.repositories.PostRepository;
import com.marcelohsousa.courseSpringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
