package com.example.tribeCarrier.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tribe_user_login_activity")
public class TribeUserLoginEntity {

  @Id
  @GeneratedValue
  @Column
  private int id;

  @Column
  private String email;

  @Column
  private String isLoggedIn;

  @Column
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
  private Timestamp sessionTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIsLoggedIn() {
    return isLoggedIn;
  }

  public void setIsLoggedIn(String isLoggedIn) {
    this.isLoggedIn = isLoggedIn;
  }

  public Timestamp getSessionTime() {
    return sessionTime;
  }

  public void setSessionTime(Timestamp sessionTime) {
    this.sessionTime = sessionTime;
  }

}
