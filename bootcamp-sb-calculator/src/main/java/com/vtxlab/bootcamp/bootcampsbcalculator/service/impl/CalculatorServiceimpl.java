package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.vtxlab.bootcamp.bootcampsbcalculator.exception.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceimpl implements CalculatorService {
  
  public static Calculator calculator = new Calculator();

  @Override
  public Calculator cal(String x, String y, Operation op) throws InvalidInputException {
    try {
       //calculator = new Calculator();
      calculator.cal(x, y, op);
      return calculator;
    } catch (NumberFormatException e) {
      throw new InvalidInputException();
    } catch (MethodArgumentTypeMismatchException e2) {
      throw new InvalidInputException();
    }
  };

  @Override
  public void store(Calculator c) {
    calculator.setX(c.getX());
    calculator.setY(c.getY());
    calculator.setOperation(c.getOperation());
  };


}
