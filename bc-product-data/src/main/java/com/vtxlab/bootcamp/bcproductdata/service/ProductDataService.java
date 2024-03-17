package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;

public interface ProductDataService {
  
  List<CoinsIdEntity> saveCoinsIds(List<CoinsIdEntity> coinsIds);

  List<CoinsIdEntity> getAllCoinsIds();

  List<CoinsIdEntity> getCoinsIdsByCoinsIds(List<String> coinsIds);

  List<StocksIdEntity> saveStocksIds(List<StocksIdEntity> stocksIds);

  List<StocksIdEntity> getAllStockIds();

  List<StocksIdEntity> getStocksIdsByStocksIds(List<String> stocksIds);

  void deleteCoinsIds(List<CoinsIdEntity> coinsIds);

  void deleteStocksIds(List<StocksIdEntity> stocksIds);
}
