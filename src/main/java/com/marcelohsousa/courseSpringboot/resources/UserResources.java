package com.marcelohsousa.courseSpringboot.resources;


import com.marcelohsousa.courseSpringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {


    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User>  list = new ArrayList<>();

        list.add(new User(null, "maria", "maria@gmail.com"));
        list.add(new User(null, "joao", "joao@gmail.com"));

        return ResponseEntity.ok().body(list);
    }
}
