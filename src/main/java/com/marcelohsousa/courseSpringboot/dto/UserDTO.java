package com.marcelohsousa.courseSpringboot.dto;

import com.marcelohsousa.courseSpringboot.entities.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;


public class UserDTO implements Serializable {



    @Id
    private String id;
    private String name;
    private String email;

    public UserDTO(){
    }

    public UserDTO(User obj){

        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;
        return getId().equals(userDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
