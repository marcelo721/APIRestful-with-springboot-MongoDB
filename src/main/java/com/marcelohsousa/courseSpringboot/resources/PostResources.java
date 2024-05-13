package com.marcelohsousa.courseSpringboot.resources;


import com.marcelohsousa.courseSpringboot.dto.UserDTO;
import com.marcelohsousa.courseSpringboot.entities.Post;
import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.services.PostService;
import com.marcelohsousa.courseSpringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResources {
    
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById( @PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
