package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bcproductdata.controller.ProductDataOperation;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@RestController
public class ProductDataController implements ProductDataOperation {
  
  @Autowired
  ProductDataService productDataService;

  @Override
  public List<CoinsIdEntity> saveCoinsIds(String coinsIdList) {    
    List<String> coinIdsList =  BcUtil.csvToList(coinsIdList);
    List<String> existingCoinIdIdEntityList = productDataService.getAllCoinsIds().stream()
            .map(e -> e.getCoinId())
            .collect(Collectors.toList());

    List<CoinsIdEntity> coinsIdEntityList = coinIdsList.stream()
                .filter(e -> !(existingCoinIdIdEntityList.contains(e)))
                .map(e -> {
                  return CoinsIdEntity.builder()
                          .coinId(e)
                          .build();
                })
                .collect(Collectors.toList());

                productDataService.saveCoinsIds(coinsIdEntityList);
    return coinsIdEntityList;
  };

  @Override
  public List<StocksIdEntity> saveStocksIds(String stocksIdList) {
        List<String> stockIdList =  BcUtil.csvToList(stocksIdList);
        List<String> existingStocksIdEntityList = productDataService.getAllStocksIds().stream()
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

    productDataService.saveStocksIds(stocksIdEntityList);
    return stocksIdEntityList;
  };

  @Override
  public List<CoinsIdEntity> deleteCoinsIds(String coinsIdList) {  
    List<String> coinIdsList =  BcUtil.csvToList(coinsIdList);
    List<CoinsIdEntity> coinsIdEntityList = productDataService.getCoinsIdsByCoinsIds(coinIdsList);
    System.out.println(coinsIdEntityList);
    productDataService.deleteCoinsIds(coinsIdEntityList);
    return coinsIdEntityList;
  };

  @Override
  public List<StocksIdEntity> deleteStocksIds(String stocksIdList) {
    List<String> stockIdList =  BcUtil.csvToList(stocksIdList);
    List<StocksIdEntity> stocksIdEntityList = productDataService.getStocksIdsByStocksIds(stockIdList);
    System.out.println(stocksIdEntityList);
    productDataService.deleteStocksIds(stocksIdEntityList);
    return stocksIdEntityList;
  };

}
