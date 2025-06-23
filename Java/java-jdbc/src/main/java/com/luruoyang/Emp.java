package com.luruoyang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
  private Long id;
  private String username;
  private String password;
  private String name;
  private Integer gender;
  private String phone;
  private Integer job;
  private Long salary;
  private String image;
  private Date entry_date;
  private LocalDateTime create_time;
  private LocalDateTime update_time;
}
