package com.vtxlab.bootcamp.bootcampsbcalculator.service;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;

public interface CalculatorService {
  
  Calculator cal(String x, String y, String o) throws InvalidInputException;
  
  Calculator store(Calculator calculator);

}
