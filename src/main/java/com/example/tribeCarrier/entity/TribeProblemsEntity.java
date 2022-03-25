package com.example.tribeCarrier.entity;


import javax.persistence.*;

@Entity
@Table(name = "TribeProblem")
public class TribeProblemsEntity {

  @Id
  @GeneratedValue
  @Column
  private int problemId;

  @Column
  private String owner;

  @Column
  private String category;

  @Column
  private String experience;

  @Column
  private String filepath;


  public int getProblemId() {
    return problemId;
  }

  public void setProblemId(int problemId) {
    this.problemId = problemId;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

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

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }
}
