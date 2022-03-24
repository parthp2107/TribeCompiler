package com.example.tribeCarrier.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tribe_user_login_activity")
public class TribeUserLoginEntity {

  @Id
  @Column
  private int id;

  @Column
  private String email;

  @Column
  private String isLoggedIn;

  @Column
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Temporal(TemporalType.DATE)
  private Date sessionDate;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm:ss")
  @Temporal(TemporalType.TIME)
  private Date sessionTime;

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


  public Date getSessionDate() {
    return sessionDate;
  }

  public void setSessionDate(Date  sessionDate) {
    this.sessionDate = sessionDate;
  }

  public Date getSessionTime() {
    return sessionTime;
  }

  public void setSessionTime(Date sessionTime) {
    this.sessionTime = sessionTime;
  }

}
