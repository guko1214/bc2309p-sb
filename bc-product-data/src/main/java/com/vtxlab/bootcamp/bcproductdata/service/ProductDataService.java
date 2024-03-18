package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;

public interface ProductDataService {
  
  List<CoinsIdEntity> saveCoinsIds(List<CoinsIdEntity> coinsIds);

  List<CoinsIdEntity> getAllCoinsIds();

  List<CoinsIdEntity> getCoinsIdsByCoinsIds(List<String> coinsIds);

  List<StocksIdEntity> saveStocksIds(List<StocksIdEntity> stocksIds);

  List<StocksIdEntity> getAllStocksIds();

  List<StocksIdEntity> getStocksIdsByStocksIds(List<String> stocksIds);

  void deleteCoinsIds(List<CoinsIdEntity> coinsIds);

  void deleteStocksIds(List<StocksIdEntity> stocksIds);

  List<TexCPCoingeckoMKEntity> saveAllTexCPCoingeckoMKEntites(List<TexCPCoingeckoMKEntity> coinsEntity);

  List<TexSkFinnhubQuoteEntity> saveAllTexSkFinnhubQuoteEntities(List<TexSkFinnhubQuoteEntity> stocksEntity);

  List<TexSKFinnhubProfile2Entity> saveAllTexSKFinnhubProfile2Entities(List<TexSKFinnhubProfile2Entity> stocksEntity);

  void deleteAllTexCPCoingeckoMKEntites();

  void deleteAllTexSkFinnhubQuoteEntities();

  void deleteAllTexSKFinnhubProfile2Entitiess();
  
}
