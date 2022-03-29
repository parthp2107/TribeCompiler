package com.example.tribeCarrier.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRIBE_COMPILER")
public class TribeCreateUserEntity {

  @Id
  @Column
  @GeneratedValue
  private int id;

  @Column
  private String name;

  @Column
  private String password;

  @Column
  private String email;

  @Column
  private String user_experience;

  public int getUserId() {
    return id;
  }

  public void setUserId(int id) {
    this.id = id;
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

  public String getUser_experience() {
    return user_experience;
  }

  public void setUser_experience(String user_experience) {
    this.user_experience = user_experience;
  }

}
