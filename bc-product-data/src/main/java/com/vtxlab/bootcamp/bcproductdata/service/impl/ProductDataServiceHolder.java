package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexCPCoingeckoMKEntityRespository;
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
  TexCPCoingeckoMKEntityRespository texCPCoingeckoMKEntityRespository;

  @Autowired
  TexSkFinnhubQuoteEntityRepository texSkFinnhubQuoteEntityRepository;

  @Autowired
  TexSKFinnhubProfile2EntityRepository texSKFinnhubProfile2EntityRepository;

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
  public List<StocksIdEntity> getAllStocksIds() {
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

}
