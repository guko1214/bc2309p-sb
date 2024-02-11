package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Operation {
  
  ADD("add"), SUB("sub"), MUL("mul"), DIV("div"),
  ;

  private String name;
}
