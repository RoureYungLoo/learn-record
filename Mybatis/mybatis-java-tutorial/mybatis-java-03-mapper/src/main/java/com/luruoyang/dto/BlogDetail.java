package com.luruoyang.dto;

import com.luruoyang.entity.*;
import lombok.Data;

import java.util.List;

/*@Data
public class BlogDetail {
  private Blog blog;
  private Author author;
  private Post post;
  private List<Comment> commentList;
  private List<Tag> tagList;
}*/

@Data
public class BlogDetail {
  private Long blogId;
  private String title;
  private Author author;
  private List<Post> posts;
}