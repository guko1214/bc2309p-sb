package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import lombok.Builder;

@Builder
public class ApiResponse {
  
  private String code;
  private String message;

  private ApiResponse (String code, String message) {
    this.code = code;
    this.message = message;
  }

  public static ApiResponseBuilder builder() {
    return new ApiResponseBuilder();
  }

  public static class ApiResponseBuilder {

    private String code;
    private String message;

    public ApiResponseBuilder status(Syscode syscode) {
      this.code = syscode.getCode();
      this.message = syscode.getMessage();
      return this;
    }

    public ApiResponse build() {
      return new ApiResponse(this.code, this.message);
    }

  }

}
