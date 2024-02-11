package com.vtxlab.bootcamp.bootcampsbcalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  public ApiResponse  invalidInputExceptionalHandler() {
    return ApiResponse.builder().status(Syscode.NOTFOUND).build();
  }
}
