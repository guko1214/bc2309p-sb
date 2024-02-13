package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

public class InvalidInputException extends Exception {
  private String code;
  public InvalidInputException () {
    super(Syscode.NOTFOUND.getMessage());
    this.code = Syscode.NOTFOUND.getCode();
  }
}
