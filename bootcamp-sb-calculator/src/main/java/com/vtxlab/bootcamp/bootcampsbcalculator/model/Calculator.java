package com.vtxlab.bootcamp.bootcampsbcalculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Getter
// @Setter
// @EqualsAndHashCode
// @ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calculator {

  private String x;
  private String y;
  //private Operation operation;
  private String operation;

  public String cal(String x, String y, Operation op) {
    this.x = String.valueOf(Double.parseDouble(x));
    this.y = String.valueOf(Double.parseDouble(y));
    this.operation = op.getName();
    String ans = "";
    switch (op) {
      case ADD:
        ans = this.add();
        break;
      case SUB:
      ans =  this.sub();
        break;        
      case MUL:
      ans =  this.mul();
        break;  
      case DIV:
      ans =  this.div();
        break;        
    }    
    return ans;
  }

  public String add() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    return String.valueOf(valueX.add(valueY));
  }

  public String sub() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    return String.valueOf(valueX.subtract(valueY));
  }

  public String mul() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    return String.valueOf(valueX.multiply(valueY));
  }

  public String div() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    BigDecimal result = valueX.divide(valueY,5,RoundingMode.DOWN);
    //double resDouble = result.doubleValue();
    String reString = String.valueOf(result);
    return reString;
  }

}
