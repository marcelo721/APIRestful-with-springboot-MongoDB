package com.marcelohsousa.courseSpringboot.config;


import com.marcelohsousa.courseSpringboot.dto.AuthorDTO;
import com.marcelohsousa.courseSpringboot.dto.CommentDTO;
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
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018").toInstant(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018").toInstant(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));


        CommentDTO c1 = new CommentDTO("boa viagem mano", sdf.parse("21/12/2019").toInstant(), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("boa viagem mano", sdf.parse("22/12/2019").toInstant(), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("boa viagem mano", sdf.parse("23/12/2019").toInstant(), new AuthorDTO(maria));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }



}
