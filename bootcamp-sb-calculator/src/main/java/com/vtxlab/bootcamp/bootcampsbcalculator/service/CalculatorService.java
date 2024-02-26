package com.vtxlab.bootcamp.bootcampsbcalculator.service;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.CalculatorRecord;

@Service
public interface CalculatorService {
  
  String cal(String x, String y, String o) throws InvalidInputException;

  Calculator getCalculator(String x, String y, String o) throws InvalidInputException;
  
  //Calculator store(Calculator calculator);
  CalculatorRecord store(Calculator calculator);

}
