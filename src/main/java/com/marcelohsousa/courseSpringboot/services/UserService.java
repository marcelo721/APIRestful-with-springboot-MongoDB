package com.marcelohsousa.courseSpringboot.services;


import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.repositories.UserRepository;
import com.marcelohsousa.courseSpringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
