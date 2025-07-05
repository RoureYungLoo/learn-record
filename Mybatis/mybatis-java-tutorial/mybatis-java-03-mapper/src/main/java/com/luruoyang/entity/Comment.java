package com.luruoyang.entity;

import lombok.Data;

@Data
public class Comment {
  private Long id;
  private Long tb_post_id;
  private String name;
  private String comment;
}
