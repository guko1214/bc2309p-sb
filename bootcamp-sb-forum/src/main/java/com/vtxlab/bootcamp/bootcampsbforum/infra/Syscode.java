package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Syscode {
  OK("000000","OK."), NOTFOUND("000001","Resource Not Found"),;

  private String code;
  private String message;

  // Syscode(String code,String message) {
  //   this.code = code;
  //   this.message = message;
  // }

}

