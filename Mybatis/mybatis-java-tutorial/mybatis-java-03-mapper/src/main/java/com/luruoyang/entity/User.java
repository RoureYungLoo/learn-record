package com.luruoyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;
  private Long userId;
  private String userName;
  private String userAvatar;
  private String userPassWord;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
