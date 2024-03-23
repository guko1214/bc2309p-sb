package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;

public interface ProductDataService {
  
  List<TproductCoinListEntity> saveCoinList(List<TproductCoinListEntity> coinCodes);

  List<TproductCoinListEntity> getCoinList();

  List<TproductCoinListEntity> getCoinListByCoinCodes(List<String> coinCodes);

  List<TproductStockListEntity> saveStockList(List<TproductStockListEntity> stockCodes);

  List<TproductStockListEntity> getStockList();

  List<TproductStockListEntity> getStockListByStockCodes(List<String> stockCodes);

  void deleteCoinList(List<TproductCoinListEntity> coinCodes);

  void deleteStockList(List<TproductStockListEntity> stockCodes);

  List<TexCPCoingeckoMKEntity> saveAllTexCPCoingeckoMKEntites(List<TexCPCoingeckoMKEntity> coinsEntity);

  List<TexSkFinnhubQuoteEntity> saveAllTexSkFinnhubQuoteEntities(List<TexSkFinnhubQuoteEntity> stocksEntity);

  List<TexSKFinnhubProfile2Entity> saveAllTexSKFinnhubProfile2Entities(List<TexSKFinnhubProfile2Entity> stocksEntity);

  void deleteAllTexCPCoingeckoMKEntites();

  void deleteAllTexSkFinnhubQuoteEntities();

  void deleteAllTexSKFinnhubProfile2Entitiess();

  void saveOrUpdateTproductCoinsEntity(List<TproductCoinListEntity> coinList, List<TexCPCoingeckoMKEntity> textCPCoingecko);
}
