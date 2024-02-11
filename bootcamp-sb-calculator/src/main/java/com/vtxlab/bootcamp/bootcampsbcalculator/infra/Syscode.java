package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Syscode {
  OK("0","OK."), 
  NOTFOUND("9","Invalid Input."),//
  ;

  private String code;
  private String message;

  // Syscode(String code,String message) {
  //   this.code = code;
  //   this.message = message;
  // }

}

