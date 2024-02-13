package com.vtxlab.bootcamp.bootcampsbcalculator.service;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;

@Service
public interface CalculatorService {
  
  Calculator cal(String x, String y, String o) throws InvalidInputException;
  
  Calculator store(Calculator calculator);

}
