package com.example.tribeCarrier.entity;


public class TribeEntity {

  public TribeEntity() {}
  private String codeString;
  private String stdInString;

  public TribeEntity(String codeString, String stdInString){
    super();
    this.codeString = codeString;
    this.stdInString = stdInString;
  }

  public String getCodeString() {
    return codeString;
  }

  public void setCodeString() {
    this.codeString = codeString;
  }

  public String getStdInString() {
    return stdInString;
  }

  public void setStdInString() {
    this.stdInString = stdInString;
  }
}
