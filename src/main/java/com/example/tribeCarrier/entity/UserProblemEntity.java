package com.example.tribeCarrier.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_problem_reference")
public class UserProblemEntity implements Serializable {

  @Id
  @Column
  @GeneratedValue
  private int id;

  @Column
  private int userId;

  @Column
  private int problemId;

  @Column
  private int problemTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getProblemId() {
    return problemId;
  }

  public void setProblemId(int problemId) {
    this.problemId = problemId;
  }

  public int getProblemTime() {
    return problemTime;
  }

  public void setProblemTime(int problemTime) {
    this.problemTime = problemTime;
  }
}
