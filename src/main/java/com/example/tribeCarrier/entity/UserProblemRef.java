package com.example.tribeCarrier.entity;

import java.util.List;

public class UserProblemRef {

  private int user_id;

  private List<Object> problem_id;


  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public List<Object> getProblem_id() {
    return problem_id;
  }

  public void setProblem_id(List<Object> problem_id) {
    this.problem_id = problem_id;
  }
}
