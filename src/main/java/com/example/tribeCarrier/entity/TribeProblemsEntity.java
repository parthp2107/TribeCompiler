package com.example.tribeCarrier.entity;


import javax.persistence.*;

@Entity
@Table(name = "TribeProblem")
public class TribeProblemsEntity {

  @Id
  @GeneratedValue
  @Column
  private int problem_id;

  @Column
  private String problem_name;

  @Column
  private String owner;

  @Column
  private String category;

  @Column
  private String problem_experience;

  public int getProblem_id() {
    return problem_id;
  }

  public void setProblem_id(int problem_id) {
    this.problem_id = problem_id;
  }

  public String getProblem_name() {
    return problem_name;
  }

  public void setProblem_name(String problem_name) {
    this.problem_name = problem_name;
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

  public String getProblem_experience() {
    return problem_experience;
  }

  public void setProblem_experience(String problem_experience) {
    this.problem_experience = problem_experience;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  @Column
  private String filepath;

}
