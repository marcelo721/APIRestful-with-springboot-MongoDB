package com.marcelohsousa.courseSpringboot.resources;


import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}