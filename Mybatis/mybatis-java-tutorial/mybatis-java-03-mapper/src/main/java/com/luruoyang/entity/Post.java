package com.luruoyang.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {
  private Long id;
  private Integer tb_blog_id;
  private Integer tb_author_id;
  private LocalDateTime created_on;
  private String section;
  private String subject;
  private String draft;
  private String body;

  private Author author;
  private List<Comment> comments;
  private List<Tag> tags;
}
