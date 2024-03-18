package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bcproductdata.controller.ProductDataOperation;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@RestController
public class ProductDataController implements ProductDataOperation {
  
  @Autowired
  ProductDataService productDataService;

  @Override
  public List<TproductCoinListEntity> saveCoinListEntities(String coinCodeCsv) {    
    List<String> coinCodeList =  BcUtil.csvToList(coinCodeCsv);
    List<String> existingCoinCodeList = productDataService.getCoinList().stream()
            .map(e -> e.getCoinCode())
            .collect(Collectors.toList());

    List<TproductCoinListEntity> coinListEntities = coinCodeList.stream()
                .filter(e -> !(existingCoinCodeList.contains(e)))
                .map(e -> {
                  return TproductCoinListEntity.builder()
                          .coinCode(e)
                          .build();
                })
                .collect(Collectors.toList());

                productDataService.saveCoinList(coinListEntities);
    return coinListEntities;
  };

  @Override
  public List<TproductStockListEntity> saveStockListEntities(String stockCodeCsv) {
        List<String> stockCodeList =  BcUtil.csvToList(stockCodeCsv);
        List<String> existingStockCodeList = productDataService.getStockList().stream()
                              .map(e -> e.getStockCode())
                              .collect(Collectors.toList());

    List<TproductStockListEntity> stockListEntities = stockCodeList.stream()
                .filter(e -> !(existingStockCodeList.contains(e)))
                .map(e -> {
                  return TproductStockListEntity.builder()
                          .stockCode(e)
                          .build();
                })
                .collect(Collectors.toList());

    productDataService.saveStockList(stockListEntities);
    return stockListEntities;
  };

  @Override
  public List<TproductCoinListEntity> deleteCoinList(String coinCodeCsv) {  
    List<String> coinCodeList =  BcUtil.csvToList(coinCodeCsv);
    List<TproductCoinListEntity> coinListEntities = productDataService.getCoinListByCoinCodes(coinCodeList);
    System.out.println(coinListEntities);
    productDataService.deleteCoinList(coinListEntities);
    return coinListEntities;
  };

  @Override
  public List<TproductStockListEntity> deleteStockList(String stockCodeCsv) {
    List<String> stockCodeList =  BcUtil.csvToList(stockCodeCsv);
    List<TproductStockListEntity> stockListEntitiess = productDataService.getStockListByStockCodes(stockCodeList);
    System.out.println(stockListEntitiess);
    productDataService.deleteStockList(stockListEntitiess);
    return stockListEntitiess;
  };

}
