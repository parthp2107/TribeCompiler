package com.example.tribeCarrier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
  private String session;

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

  public String isLoggedIn() {
    return isLoggedIn;
  }

  public void setIsLoggedIn(String isLoggedIn) {
    this.isLoggedIn = isLoggedIn;
  }

  public String getSession() {
    return session;
  }

  public void setSession(String  session) {
    this.session = session;
  }

}
