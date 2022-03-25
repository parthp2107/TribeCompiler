package com.example.tribeCarrier.entity;


import java.lang.reflect.Array;
import java.util.List;

public class TribeEntity {

  public TribeEntity() {}
  private String codeString;

  private List<String> stdInString;

  public TribeEntity(String codeString, List<String> stdInString){
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

  public List<String> getStdInString() {
    return stdInString;
  }

  public void setStdInString(List<String> stdInString) {
    this.stdInString = stdInString;
  }


}
