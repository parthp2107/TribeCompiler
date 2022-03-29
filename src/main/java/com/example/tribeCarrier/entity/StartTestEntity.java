package com.example.tribeCarrier.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "start_test_record")
public class StartTestEntity {

  @Id
  @Column
  private int user_id;

  @Column
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
  private Timestamp startTime;

  @Column
  private int cumulative_time_minutes;

  @Column
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
  private Timestamp endTime;

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  public int getCumulative_time_minutes() {
    return cumulative_time_minutes;
  }

  public void setCumulative_time_minutes(int cumulative_time_minutes) {
    this.cumulative_time_minutes = cumulative_time_minutes;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }
}
