package com.nemesis.training;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;

  public User(String name) {
    this.name = name;
  }
}
