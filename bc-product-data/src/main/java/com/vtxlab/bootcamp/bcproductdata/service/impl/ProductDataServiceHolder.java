package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.StocksIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@Service
public class ProductDataServiceHolder implements ProductDataService {
  
  @Autowired
  CoinsIdEntityRepository coinsIdEntityRespository;

  @Autowired
  StocksIdEntityRepository stocksIdEntityRespository;

  @Override
  public List<CoinsIdEntity> saveCoinsIds(List<CoinsIdEntity> coinsIds) {
    return coinsIdEntityRespository.saveAll(coinsIds);
  };

  @Override
  public List<CoinsIdEntity> getAllCoinsIds() {
    return coinsIdEntityRespository.findAll();
  };

  @Override
  public List<CoinsIdEntity> getCoinsIdsByCoinsIds(List<String> coinsIds) {
    return coinsIdEntityRespository.findAll().stream()
            .filter(e -> coinsIds.contains(e.getCoinId()))
            .collect(Collectors.toList());
  };

  @Override
  public List<StocksIdEntity> saveStocksIds(List<StocksIdEntity> stocksIds) {
    return stocksIdEntityRespository.saveAll(stocksIds);
  };

  @Override
  public List<StocksIdEntity> getAllStockIds() {
    return stocksIdEntityRespository.findAll();
  };

  @Override
  public List<StocksIdEntity> getStocksIdsByStocksIds(List<String> stocksIds) {
    return stocksIdEntityRespository.findAll().stream()
            .filter(e -> stocksIds.contains(e.getStockId()))
            .collect(Collectors.toList());
  };

  @Override
  public void deleteCoinsIds(List<CoinsIdEntity> coinsIds) {
    coinsIdEntityRespository.deleteAll(coinsIds);
  };

  @Override
  public void deleteStocksIds(List<StocksIdEntity> stocksIds) {
    stocksIdEntityRespository.deleteAll(stocksIds);
  };

}
