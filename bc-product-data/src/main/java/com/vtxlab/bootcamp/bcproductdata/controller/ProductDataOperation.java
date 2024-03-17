package com.vtxlab.bootcamp.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;

public interface ProductDataOperation {
  
  @PostMapping(value = "/coinsid")
  @ResponseStatus(value = HttpStatus.OK)
  List<CoinsIdEntity> saveCoinsIds(@RequestParam(value = "coinsids") String coinsIdList);

  @PostMapping(value = "/stocksid")
  @ResponseStatus(value = HttpStatus.OK)
  List<StocksIdEntity> saveStocksIds(@RequestParam(value = "stocksids") String stocksIdList);
  
  @DeleteMapping(value = "/coinsid")
  @ResponseStatus(value = HttpStatus.OK)
  List<CoinsIdEntity> deleteCoinsIds(@RequestParam(value = "coinsids") String coinsIdList);
  
  @DeleteMapping(value = "/stocksid")
  @ResponseStatus(value = HttpStatus.OK)
  List<StocksIdEntity> deleteStocksIds(@RequestParam(value = "stocksids") String stocksIdList);
}
