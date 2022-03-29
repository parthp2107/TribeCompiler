package com.example.tribeCarrier.entity;

import javax.persistence.Column;


public class TribeProblemStatementEntity {

  public TribeProblemStatementEntity() {}

  @Column
  private String category;

  @Column
  private String problem_experience;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getProblemExperience() {
    return problem_experience;
  }

  public void setExperience(String problem_experience) {
    this.problem_experience = problem_experience;
  }

}
