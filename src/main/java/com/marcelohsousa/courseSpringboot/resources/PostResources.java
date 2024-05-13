package com.marcelohsousa.courseSpringboot.resources;


import com.marcelohsousa.courseSpringboot.entities.Post;
import com.marcelohsousa.courseSpringboot.resources.util.URL;
import com.marcelohsousa.courseSpringboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findBytTitle(@RequestParam(value = "text", defaultValue = "") String text){

        text = URL.decodeParam(text);

        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
