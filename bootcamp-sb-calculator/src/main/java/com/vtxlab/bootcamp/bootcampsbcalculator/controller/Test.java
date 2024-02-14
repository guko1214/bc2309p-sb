package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

import com.vtxlab.bootcamp.bootcampsbcalculator.dto.CalculatorDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.dto.mapper.CalResultMapper;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.impl.CalculatorServiceimpl;

public class Test {

  public CalculatorDTO cal1(String x, String y, String operation) throws InvalidInputException { 
    CalculatorService calculatorService = new CalculatorServiceimpl();
    String result = calculatorService.cal(x,y,operation);   
    //Calculator c2 = calculatorService.getCalculator(x, y, operation); 
    Calculator c2 = Calculator.builder().x(x).y(y).operation(operation).build();
    return CalResultMapper.calResultDTO(calculatorService.getCalculator(x, y, operation) //
            ,calculatorService.cal(x,y,operation));
  }
  public static void main(String[] args) throws InvalidInputException  {
    // Test t = new Test();
    // System.out.println(t.cal1("2","3","ADD"));
    // System.out.println(Operation.nameToOp("ds"));
    CalculatorServiceimpl calculatorServiceimpl = new CalculatorServiceimpl();
    Calculator c = Calculator.builder().x("2.0").y("3.0").operation("ADD").build();
    Calculator c2 = calculatorServiceimpl.getCalculator("2.0", "3.0", "ADD");
    System.out.println(c.getX().equals(c2.getX()));
    System.out.println(c.getY().equals(c2.getY()));
    System.out.println(c.getOperation().equals(c2.getOperation()));
    System.out.println(c.equals(c2));
  }
}
