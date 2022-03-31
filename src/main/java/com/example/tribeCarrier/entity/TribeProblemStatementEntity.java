package com.example.tribeCarrier.entity;

import javax.persistence.Column;


public class TribeProblemStatementEntity {

  public TribeProblemStatementEntity() {}

  private int problemId;

  private String category;

  private String problem_experience;


  public int getProblemId() {
    return problemId;
  }

  public void setProblemId(int problemId) {
    this.problemId = problemId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getProblem_experience() {
    return problem_experience;
  }

  public void setProblem_experience(String problem_experience) {
    this.problem_experience = problem_experience;
  }

}
