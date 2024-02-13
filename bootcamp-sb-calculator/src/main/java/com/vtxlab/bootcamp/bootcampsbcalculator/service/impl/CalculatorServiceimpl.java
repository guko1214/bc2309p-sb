package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceimpl implements CalculatorService {
  
  public static Calculator calculator = new Calculator();

  @Override
  public Calculator cal(String x, String y, String o) throws InvalidInputException {
    try {
       //calculator = new Calculator();
       Optional<Operation> op = Optional.empty();
       switch (o) {
         case "ADD":
           op = Optional.of(Operation.ADD);
           break;
         case "SUB":
           op = Optional.of(Operation.SUB);
           break;
         case "MUL":
           op = Optional.of(Operation.MUL);
           break;
         case "DIV":
           op = Optional.of(Operation.DIV);
           break;
       }
      op.orElseThrow(() -> new InvalidInputException());
      calculator.cal(x, y, op.get());
      return calculator;
    } catch (NumberFormatException e) {
      throw new InvalidInputException();
    }
  };

  @Override
  public Calculator store(Calculator c) {
    calculator.setX(c.getX());
    calculator.setY(c.getY());
    calculator.setOperation(c.getOperation());
    return calculator;
  };

  public static void main(String[] args) {
   for (Operation op : Operation.values()) {
    System.out.println(op.name());
   } 
  }
}
