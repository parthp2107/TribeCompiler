package com.example.tribeCarrier.entity;

import javax.persistence.Column;


public class TribeProblemStatementEntity {

  public TribeProblemStatementEntity() {}

  @Column
  private String category;

  @Column
  private String experience;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

}
