package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceimpl implements CalculatorService {
  
  public static Calculator calculator = new Calculator();
  //public static Calculator calculator;

  @Override
  public String cal(String x, String y, String o) throws InvalidInputException {
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
      //Calculator calculator = new Calculator();
      return calculator.cal(x, y, op.get());
    } catch (NumberFormatException e) {
      throw new InvalidInputException();
    }
  };

  @Override
  public Calculator getCalculator(String x, String y, String o) throws InvalidInputException {
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
    //  calculator.setX(x);
    //  calculator.setY(y);
    //  calculator.setOperation(o);
     //return calculator;
     return new Calculator(x, y, o);
   } catch (NumberFormatException e) {
     throw new InvalidInputException();
   }
  };

  @Override
  public Calculator store(Calculator c) {
    // calculator.setX(c.getX());
    // calculator.setY(c.getY());
    // calculator.setOperation(c.getOperation());
    return new Calculator(c.getX(), c.getY(), c.getOperation());
    // return calculator;
    // if (CalculatorDatabase.getCalculators().add(c))
    //   return c;
    // return null;
  };

}
