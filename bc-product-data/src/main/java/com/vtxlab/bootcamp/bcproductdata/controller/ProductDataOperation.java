package com.vtxlab.bootcamp.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductDailyDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductsDTO;
import com.vtxlab.bootcamp.bcproductdata.infra.ApiResponse;

public interface ProductDataOperation {

  @GetMapping(value = "/product/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<TproductsDTO>> getTproductCoinsEntity();

  @GetMapping(value = "/product/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<TproductsDTO>> getTproductStocksEntity();

  @GetMapping(value = "/products")  
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<TproductsDTO>> getTproductsEntity();

  @GetMapping(value = "/product/stock/daily")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<TproductDailyDTO>> getTproductStocksDailyEntity(@RequestParam(value = "code") String stockcode);
}
