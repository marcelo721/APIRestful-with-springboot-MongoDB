package com.marcelohsousa.courseSpringboot.services;


import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
