package com.vtxlab.bootcamp.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;

public interface ProductDataOperation {
  
  @PostMapping(value = "/coinsid")
  @ResponseStatus(value = HttpStatus.OK)
  List<TproductCoinListEntity> saveCoinListEntities(@RequestParam(value = "coinsids") String coinsIdList);

  @PostMapping(value = "/stocksid")
  @ResponseStatus(value = HttpStatus.OK)
  List<TproductStockListEntity> saveStockListEntities(@RequestParam(value = "stocksids") String stocksIdList);
  
  @DeleteMapping(value = "/coinsid")
  @ResponseStatus(value = HttpStatus.OK)
  List<TproductCoinListEntity> deleteCoinList(@RequestParam(value = "coinsids") String coinsIdList);
  
  @DeleteMapping(value = "/stocksid")
  @ResponseStatus(value = HttpStatus.OK)
  List<TproductStockListEntity> deleteStockList(@RequestParam(value = "stocksids") String stocksIdList);
}
