package com.example.tribeCarrier.entity;

import java.util.List;

public class UserProblemRef {

  private int userId;

  private List<Object> problemId;

  private List<Object> problemTime;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public List<Object> getProblemId() {
    return problemId;
  }

  public void setProblemId(List<Object> problemId) {
    this.problemId = problemId;
  }

  public List<Object> getProblemTime() {
    return problemTime;
  }

  public void setProblemTime(List<Object> problemTime) {
    this.problemTime = problemTime;
  }
}
