package com.nemesis.training;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

// use Lombok @Getter and @Setter annotations to provide getter and setter methods
@Getter
@Setter

// Serializable user fields with `id` and `name`
public class User implements Serializable {
    private Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}

