package com.vtxlab.bootcamp.bootcampsbcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

//@Getter
//@ToString
@Builder
@Data
public class CalculatorDTO {

  public CalculatorDTO (String x, String y, String operation, String result) {
    this.x = x;
    this.y = y;
    this.operation = operation.toLowerCase();
    this.result = result;
  }

  private String x;
  private String y;
  private String operation;
  private String result;
  
}
