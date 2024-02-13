package com.vtxlab.bootcamp.bootcampsbcalculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {

  private String x;
  private String y;
  private Operation operation;

  public String cal(String x, String y, Operation op) {
    this.x = String.valueOf(Double.parseDouble(x));
    this.y = String.valueOf(Double.parseDouble(y));
    this.operation = op;
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

  private String add() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    return String.valueOf(valueX.add(valueY));
  }

  private String sub() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    return String.valueOf(valueX.subtract(valueY));
  }

  private String mul() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    return String.valueOf(valueX.multiply(valueY));
  }

  private String div() {
    BigDecimal valueX = BigDecimal.valueOf(Double.parseDouble(this.x));
    BigDecimal valueY = BigDecimal.valueOf(Double.parseDouble(this.y));
    BigDecimal result = valueX.divide(valueY,5,RoundingMode.DOWN);
    //double resDouble = result.doubleValue();
    String reString = String.valueOf(result);
    return reString;
  }


}
