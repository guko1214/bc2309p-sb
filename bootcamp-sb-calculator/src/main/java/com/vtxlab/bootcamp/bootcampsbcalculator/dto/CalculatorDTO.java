package com.vtxlab.bootcamp.bootcampsbcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class CalculatorDTO {

  private String x;
  private String y;
  private String operation;
  private String result;
  
}
