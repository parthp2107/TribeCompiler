package com.example.tribeCarrier.entity;

import javax.persistence.*;

@Entity
@Table(name = "TribeCompiler")
public class TribeCreateUserEntity {

  @Id
  @Column
  private int userId;

  @Column
  private String name;

  @Column
  private String password;

  @Column
  private String email;

  @Column
  private String experience;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

}
