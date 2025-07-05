package com.luruoyang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
  private Integer id;
  private String username;
  private String password;
  private String email;
  private String bio;
  private String name;
  private String favouriteSection;

}
