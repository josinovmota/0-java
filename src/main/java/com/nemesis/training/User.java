package com.nemesis.training;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}

