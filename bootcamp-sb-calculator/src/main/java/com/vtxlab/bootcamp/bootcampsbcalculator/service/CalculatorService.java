package com.vtxlab.bootcamp.bootcampsbcalculator.service;

import com.vtxlab.bootcamp.bootcampsbcalculator.exception.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;

public interface CalculatorService {
  
  Calculator cal(String x, String y, Operation op) throws InvalidInputException;
  
  void store(Calculator calculator);

}
