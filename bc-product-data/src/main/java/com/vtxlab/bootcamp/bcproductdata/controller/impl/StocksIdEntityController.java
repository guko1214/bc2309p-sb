package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bcproductdata.controller.StocksIdEntityOperation;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtxlab.bootcamp.bcproductdata.service.StocksIdService;

@RestController
@RequestMapping(value = "/data/api/v1")
public class StocksIdEntityController implements StocksIdEntityOperation {
  
  @Autowired
  StocksIdService stockIdsService;

  @Override
  public List<StocksIdEntity> saveStocksIds(@RequestParam(value = "stocksids") String stocksIdList) {
        List<String> stockIdList =  BcUtil.csvToList(stocksIdList);
        List<String> existingStocksIdEntityList = stockIdsService.getAllStockIds().stream()
                              .map(e -> e.getStockId())
                              .collect(Collectors.toList());

    List<StocksIdEntity> stocksIdEntityList = stockIdList.stream()
                .filter(e -> !(existingStocksIdEntityList.contains(e)))
                .map(e -> {
                  return StocksIdEntity.builder()
                          .stockId(e)
                          .build();
                })
                .collect(Collectors.toList());
    // coinsIdEntityList.stream()    
    // .map(e -> coinsIdService.saveCoinsId(e));
    stockIdsService.saveStocksIds(stocksIdEntityList);
    return stocksIdEntityList;
  };

}
