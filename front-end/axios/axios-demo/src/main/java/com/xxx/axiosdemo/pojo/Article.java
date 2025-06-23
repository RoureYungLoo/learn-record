package com.xxx.axiosdemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
  private Long id;
  private String title;
  private List<String> category;
  private String time;
  private String state;
  private String coverImg;
  @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
  private LocalDateTime createTime;
  @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
  private LocalDateTime updateTime;
}

