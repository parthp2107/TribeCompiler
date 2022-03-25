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
  private String experience;

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

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

}
