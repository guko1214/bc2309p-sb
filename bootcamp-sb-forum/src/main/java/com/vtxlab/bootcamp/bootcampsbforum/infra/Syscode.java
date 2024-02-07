package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Syscode {
  OK("000000","OK."), 
  NOTFOUND("000001","Resource Not Found."),
  REST_CLIENT_EXCEPTION("900001", "RestClientException."),
  NULL_POINTER_EXCEPTION("900002","NPE."),
  RUNTIME_EXCEPTION("900003","RuntimeException"),
  GENERAL_EXCEPTION("999999","General Other Exception."), //
  ;

  private String code;
  private String message;

  // Syscode(String code,String message) {
  //   this.code = code;
  //   this.message = message;
  // }

}

