package com.vtxlab.bootcamp.bootcampsbcalculator.dto.mapper;

import com.vtxlab.bootcamp.bootcampsbcalculator.dto.CalculatorDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;

public class CalResultMapper {
  
  public static CalculatorDTO calResultDTO(Calculator c, String result) throws InvalidInputException{
    String x = c.getX();
    String y = c.getY();
    Operation op = Operation.nameToOp(c.getOperation());
    //String result = c.cal(x,y,op);
    // CalculatorDTO c2 = new CalculatorDTO(x,y,op.getName(),c.cal(x,y,op));
    // return c2;//new CalculatorDTO(x,y,op.getName(),c.cal(x,y,op));
    return CalculatorDTO.builder().x(x).y(y).operation(op.getName()).result(result).build();
  }

}
