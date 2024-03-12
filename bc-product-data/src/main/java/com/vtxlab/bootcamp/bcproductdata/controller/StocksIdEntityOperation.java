package com.vtxlab.bootcamp.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;

public interface StocksIdEntityOperation {
 
  @PostMapping(value = "/stocksid")
  @ResponseStatus(value = HttpStatus.OK)
  List<StocksIdEntity> saveStocksIds(@RequestParam(value = "stocksids") String stocksIdList);

}
