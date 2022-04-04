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
  private int problemTime;

  @Column
  private String problemName;

  @Column
  private String owner;

  @Column
  private String category;

  @Column
  private String problemExperience;

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

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public int getProblemTime() {
    return problemTime;
  }

  public void setProblemTime(int problemTime) {
    this.problemTime = problemTime;
  }

  public String getProblemName() {
    return problemName;
  }

  public void setProblemName(String problemName) {
    this.problemName = problemName;
  }

  public String getProblemExperience() {
    return problemExperience;
  }

  public void setProblemExperience(String problemExperience) {
    this.problemExperience = problemExperience;
  }

}
