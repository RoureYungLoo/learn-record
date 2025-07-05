package com.luruoyang.entity;

import lombok.Data;

@Data
public class Blog {
  private Long id;
  private String title;
  private String tb_author_id;
  private String content;
  private String state;
}
