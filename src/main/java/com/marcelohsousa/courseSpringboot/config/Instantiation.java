package com.marcelohsousa.courseSpringboot.config;


import com.marcelohsousa.courseSpringboot.dto.AuthorDTO;
import com.marcelohsousa.courseSpringboot.entities.Post;
import com.marcelohsousa.courseSpringboot.entities.User;
import com.marcelohsousa.courseSpringboot.repositories.PostRepository;
import com.marcelohsousa.courseSpringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "bob brown", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018").toInstant(), "partiu viagem", "valeu rapaziada", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/03/2018").toInstant(), "partiu viagem", "valeu rapaziada", new AuthorDTO(maria));

        postRepository.deleteAll();

        postRepository.saveAll(Arrays.asList(post1, post2));


    }
}
