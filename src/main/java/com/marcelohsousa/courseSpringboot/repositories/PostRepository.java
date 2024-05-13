package com.marcelohsousa.courseSpringboot.repositories;

import com.marcelohsousa.courseSpringboot.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
