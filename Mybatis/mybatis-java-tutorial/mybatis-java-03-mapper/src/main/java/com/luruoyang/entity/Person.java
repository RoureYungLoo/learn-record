package com.luruoyang.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Person {
  private Integer id;
  private String name;
  private String alias;
  private String gender;
  private String nationality;
  private LocalDate birthDate;
  private LocalDate deathDate;
  private String deathPlace;
  private String burialPlace;
  private String hometown;
  private String occupation;
  private String rank;
  private String education;
  private LocalDate joinDate;
  private String achievement;
  private String awards;
  private String famousBattle;
  private String organization;
  private String family;
  private String biography;
  private Integer martyr;
  private String photoUrl;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
