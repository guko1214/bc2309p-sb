package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
// @Builder
public class ApiResponse2<T> {
  
  private String code;
  private String message;
  private T data;
  
  public ApiResponse2(String code, String message, T data) {
   this.code = code;
   this.message = message;
   this.data = data;
  }
  
  public static <T> ApiResponseBuilder<T> builder() {
   return new ApiResponseBuilder();
}

  public static class ApiResponseBuilder<T> {
    private String code;
    private String message;
    private T data;
 
    ApiResponseBuilder() {
    }

    public ApiResponseBuilder<T> status(Syscode syscode) {
      this.code = syscode.getCode();
      this.message = syscode.getMessage();
      return this;
   }
 
   public ApiResponseBuilder<T> data(final T data) {
      this.data = data;
      return this;
   }

    public ApiResponse2<T> build() {
       return new ApiResponse2(this.code, this.message, this.data);
    }
 
    public String toString() {
       String var10000 = this.code;
       return "ApiResponse.ApiResponseBuilder(code=" + var10000 + ", message=" + this.message + ", data=" + String.valueOf(this.data) + ")";
    }
 }

}
