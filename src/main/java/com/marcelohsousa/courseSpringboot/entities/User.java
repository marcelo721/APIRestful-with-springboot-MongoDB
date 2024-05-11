package com.marcelohsousa.courseSpringboot.entities;

import java.io.Serializable;
import java.util.Objects;

public class User  implements Serializable {

    private Long Id;
    private String name;
    private String email;


    public User() {
    }

    public User(Long id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
