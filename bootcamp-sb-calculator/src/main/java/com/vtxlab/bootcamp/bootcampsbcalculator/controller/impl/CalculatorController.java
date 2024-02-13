package com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbcalculator.controller.CalculatorOperation;
import com.vtxlab.bootcamp.bootcampsbcalculator.dto.CalculatorDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.dto.mapper.CalResultMapper;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/v1")
public class CalculatorController implements CalculatorOperation  {
  
  @Autowired
  CalculatorService calculatorService;

  @Override
  //public CalculatorDTO cal1(String x, String y, Operation operation) throws InvalidInputException {
  public CalculatorDTO cal1(String x, String y, String operation) throws InvalidInputException {    
    return CalResultMapper.calResultDTO(calculatorService.cal(x,y,operation));
  }

  @Override
  public Calculator store(Calculator calculator) {

    return calculatorService.store(calculator);
  }

  @Override
  public CalculatorDTO cal2(String x, String y, String operation) throws InvalidInputException {

    return CalResultMapper.calResultDTO(calculatorService.cal(x,y,operation));
  }

  

}
