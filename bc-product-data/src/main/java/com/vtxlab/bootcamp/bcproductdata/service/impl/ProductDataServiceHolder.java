package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexCPCoingeckoMKEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexSKFinnhubProfile2EntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexSkFinnhubQuoteEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.StocksIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@Service
public class ProductDataServiceHolder implements ProductDataService {
  
  @Autowired
  CoinsIdEntityRepository coinsIdEntityRespository;

  @Autowired
  StocksIdEntityRepository stocksIdEntityRespository;

  @Autowired
  TexCPCoingeckoMKEntityRepository texCPCoingeckoMKEntityRespository;

  @Autowired
  TexSkFinnhubQuoteEntityRepository texSkFinnhubQuoteEntityRepository;

  @Autowired
  TexSKFinnhubProfile2EntityRepository texSKFinnhubProfile2EntityRepository;

  @Override
  public List<TproductCoinListEntity> saveCoinList(List<TproductCoinListEntity> coinCodes) {
    return coinsIdEntityRespository.saveAll(coinCodes);
  };

  @Override
  public List<TproductCoinListEntity> getCoinList() {
    return coinsIdEntityRespository.findAll();
  };

  @Override
  public List<TproductCoinListEntity> getCoinListByCoinCodes(List<String> coinsIds) {
    return coinsIdEntityRespository.findAll().stream()
            .filter(e -> coinsIds.contains(e.getCoinCode()))
            .collect(Collectors.toList());
  };

  @Override
  public List<TproductStockListEntity> saveStockList(List<TproductStockListEntity> stocksIds) {
    return stocksIdEntityRespository.saveAll(stocksIds);
  };

  @Override
  public List<TproductStockListEntity> getStockList() {
    return stocksIdEntityRespository.findAll();
  };

  @Override
  public List<TproductStockListEntity> getStockListByStockCodes(List<String> stockCodes) {
    return stocksIdEntityRespository.findAll().stream()
            .filter(e -> stockCodes.contains(e.getStockCode()))
            .collect(Collectors.toList());
  };

  @Override
  public void deleteCoinList(List<TproductCoinListEntity> coinsIds) {
    coinsIdEntityRespository.deleteAll(coinsIds);
  };

  @Override
  public void deleteStockList(List<TproductStockListEntity> stocksIds) {
    stocksIdEntityRespository.deleteAll(stocksIds);
  };

  @Override
  public List<TexCPCoingeckoMKEntity> saveAllTexCPCoingeckoMKEntites(List<TexCPCoingeckoMKEntity> coinsEntity) {
    return texCPCoingeckoMKEntityRespository.saveAll(coinsEntity);
  };

  @Override
  public List<TexSkFinnhubQuoteEntity> saveAllTexSkFinnhubQuoteEntities(List<TexSkFinnhubQuoteEntity> stocksEntity) {
    return texSkFinnhubQuoteEntityRepository.saveAll(stocksEntity);
  };

  @Override
  public List<TexSKFinnhubProfile2Entity> saveAllTexSKFinnhubProfile2Entities(List<TexSKFinnhubProfile2Entity> stocksEntity) {
    return texSKFinnhubProfile2EntityRepository.saveAll(stocksEntity);
  };

  @Override
  public void deleteAllTexCPCoingeckoMKEntites() {
    texCPCoingeckoMKEntityRespository.deleteAll();
  };

  @Override
  public void deleteAllTexSkFinnhubQuoteEntities() {
    texSkFinnhubQuoteEntityRepository.deleteAll();
  };

  @Override
  public void deleteAllTexSKFinnhubProfile2Entitiess() {
    texSKFinnhubProfile2EntityRepository.deleteAll();
  };

  @Override
  public void saveOrUpdateTproductCoinsEntity(List<TproductCoinListEntity> coinList, List<TexCPCoingeckoMKEntity> textCPCoingecko) {
    
  };


}
