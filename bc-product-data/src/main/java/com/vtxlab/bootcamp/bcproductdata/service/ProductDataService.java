package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;

public interface ProductDataService {
  
  List<TproductCoinListEntity> saveCoinList(List<TproductCoinListEntity> coinCodes);

  List<TproductCoinListEntity> getCoinList();

  List<TproductCoinListEntity> getCoinListByCoinCodes(List<String> coinCodes);

  TproductCoinListEntity getCoinListById(Long id);

  List<TproductStockListEntity> saveStockList(List<TproductStockListEntity> stockCodes);

  List<TproductStockListEntity> getStockList();

  List<TproductStockListEntity> getStockListByStockCodes(List<String> stockCodes);

  TproductStockListEntity getStockListById(Long id);

  TproductStockListEntity getStockListByCode(String code);

  void deleteCoinList(List<TproductCoinListEntity> coinCodes);

  void deleteStockList(List<TproductStockListEntity> stockCodes);

  List<TexCPCoingeckoMKEntity> saveAllTexCPCoingeckoMKEntites(List<TexCPCoingeckoMKEntity> coinsEntity);

  List<TexSkFinnhubQuoteEntity> saveAllTexSkFinnhubQuoteEntities(List<TexSkFinnhubQuoteEntity> stocksEntity);

  List<TexSKFinnhubProfile2Entity> saveAllTexSKFinnhubProfile2Entities(List<TexSKFinnhubProfile2Entity> stocksEntity);

  List<TproductCoinsEntity> saveAllTproductCoinsEntities(List<TproductCoinsEntity> tproductCoinsEntities);

  List<TproductStocksEntity> saveAllTproductStocksEntities(List<TproductStocksEntity> tproductStocksEntities);

  List<TproductStocksDailyEntity> saveAllTproductStocksDailyEntities(List<TproductStocksDailyEntity> tproductStocksDailyEntities);

  List<TexCPCoingeckoMKEntity> findAllTexCPCoingeckoMKEntites();

  List<TexSkFinnhubQuoteEntity> findAllTexSkFinnhubQuoteEntities();

  List<TexSKFinnhubProfile2Entity> findAllTexSKFinnhubProfile2Entities();

  List<TproductCoinsEntity> findAllTproductCoinsEntities();

  List<TproductStocksEntity> findAllTprodcutStocksEntities();

  List<TproductStocksDailyEntity> findAllTprodicTproductStocksDailyEntities();

  List<TproductCoinsEntity> findTproductCoinsEntitiesByCoinIdDesc(Long id);

  List<TproductStocksEntity> findTproductStocksEntitiesByStockIdDesc(Long id);

  List<TproductStocksDailyEntity> findTproductStocksDailyEntitiesByStockIdDesc(Long id);

  List<TproductStocksDailyEntity> findTproductStocksEntitiesByStockIdOrderByTradeDateAsc(Long id);

  TexCPCoingeckoMKEntity findTexCPCoingeckoMKEntityById(Long id);

  TexCPCoingeckoMKEntity findLatestTexCPCoingeckoMKEntityByQuoteCoinCode(String code);

  TexSkFinnhubQuoteEntity findLatestTexSkFinnhubQuoteEntityByQuoteStockCode(String code);

  TexSKFinnhubProfile2Entity findLatestTexSKFinnhubProfile2EntityByQuoteStockCode(String code);

  void deleteAllTexCPCoingeckoMKEntites();

  void deleteAllTexSkFinnhubQuoteEntities();

  void deleteAllTexSKFinnhubProfile2Entitiess();

}
