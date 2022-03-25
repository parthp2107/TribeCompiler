package com.example.tribeCarrier.entity;


import java.lang.reflect.Array;

public class TribeEntity {

  public TribeEntity() {}
  private String codeString;

  private Array[] stdInString;

  public TribeEntity(String codeString, Array[] stdInString){
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

  public Array[] getStdInString() {
    return stdInString;
  }

  public void setStdInString(Array[] stdInString) {
    this.stdInString = stdInString;
  }


}
