package com.example.tribeCarrier.entity;


public class TribeEntity {

  public TribeEntity() {}
  private String codeString;

  public TribeEntity(String codeString){
    super();
    this.codeString = codeString;
  }

//  @Override
//  public String toString() {
//    return "Response [codeString]" + codeString + "]";
//  }

  public String getCodeString() {
    return codeString;
  }

  public void setCodeString() {
    this.codeString = codeString;
  }


}
