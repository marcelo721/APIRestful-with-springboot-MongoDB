package com.marcelohsousa.courseSpringboot.repositories;


import com.marcelohsousa.courseSpringboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
