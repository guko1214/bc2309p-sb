package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcampsbcalculator.dto.CalculatorDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;

public interface CalculatorOperation {
  

  @GetMapping(value = "")
  CalculatorDTO cal1(@RequestParam(value = "x", required=true) String x, //
              @RequestParam(value = "y", required=true) String y,
              @RequestParam(value = "operation", required=true) String operation
   ) throws InvalidInputException;

  @PostMapping(value = "")
  Calculator store(@RequestBody Calculator calculator);

  @GetMapping(value = "/{x}/{y}/{operation}")
  CalculatorDTO cal2(@PathVariable(name = "x", required=true) String x, //
              @PathVariable(name = "y", required=true) String y,
              @PathVariable(name = "operation", required=true) String operation
    ) throws InvalidInputException;
  // Calculator cal2(@PathVariable String x, //
  //  @PathVariable String y,
  //  @PathVariable Operation operation
    // );

}
