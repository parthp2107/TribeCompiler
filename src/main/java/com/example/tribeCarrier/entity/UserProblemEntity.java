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
  private int user_id;

  @Column
  private int problem_id;

  @Column
  private int problem_time;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getProblem_id() {
    return problem_id;
  }

  public void setProblem_id(int problem_id) {
    this.problem_id = problem_id;
  }

  public int getProblem_time() {
    return problem_time;
  }

  public void setProblem_time(int problem_time) {
    this.problem_time = problem_time;
  }
}
