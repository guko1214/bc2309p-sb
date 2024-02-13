package com.vtxlab.bootcamp.bootcampsbforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse2;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

// 1. Create Bean (@Controller, @Service, @Configuration, etc), put into Context
// 2. Autowired from spring Context -> object -> use its instance method

@RestControllerAdvice // Bean
public class GlobalExceptionHandler {
  
  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse2<Void>  restclientExceptionalHandler() {
    return ApiResponse2.<Void>builder()
      .status(Syscode.REST_CLIENT_EXCEPTION) //
      .data(null) //
      .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse2<Void>  npeExceptionalHandler() {
    return ApiResponse2.<Void>builder()
      .status(Syscode.NULL_POINTER_EXCEPTION) //
      .data(null) //
      .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse2<Void>  ExceptionalHandler() {
    return ApiResponse2.<Void>builder() 
      .status(Syscode.GENERAL_EXCEPTION) //
      .data(null) //
      .build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse2<Void>  runtimeExceptionalHandler() {
    return ApiResponse2.<Void>builder()
      .status(Syscode.RUNTIME_EXCEPTION) //
      .data(null) //
      .build();
  }

}
