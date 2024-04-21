package com.vtxlab.bootcamp.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;

public interface CoinStockListOperation {
  
  @PostMapping(value = "/coinlist")
  @ResponseStatus(value = HttpStatus.CREATED)
  List<TproductCoinListEntity> saveCoinListEntities(@RequestParam(value = "coincodes") String coinCodeCsv);

  @PostMapping(value = "/stocklist")
  @ResponseStatus(value = HttpStatus.CREATED)
  List<TproductStockListEntity> saveStockListEntities(@RequestParam(value = "stockcodes") String stockCodeCsv);
  
  @DeleteMapping(value = "/coinlist")
  @ResponseStatus(value = HttpStatus.OK)
  List<TproductCoinListEntity> deleteCoinList(@RequestParam(value = "coincodes") String coinCodeCsv);
  
  @DeleteMapping(value = "/stocklist")
  @ResponseStatus(value = HttpStatus.OK)
  List<TproductStockListEntity> deleteStockList(@RequestParam(value = "stockcodes") String stockCodeCsv);


  
}
