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
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexCPCoingeckoMKEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexSKFinnhubProfile2EntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TexSkFinnhubQuoteEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TproductCoinsEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TproductStocksDailyEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.repostitory.TproductStocksEntityRepository;
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

  @Autowired
  TproductCoinsEntityRepository tproductCoinsEntityRepository;

  @Autowired
  TproductStocksEntityRepository tproductStocksEntityRepository;

  @Autowired
  TproductStocksDailyEntityRepository tproductStocksDailyEntityRepository;

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
  public TproductCoinListEntity getCoinListById(Long id) {
    return coinsIdEntityRespository.findById(id).get();
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
  public TproductStockListEntity getStockListById(Long id) {
    return stocksIdEntityRespository.findById(id).get();
  };

  @Override
  public TproductStockListEntity getStockListByCode(String code) {
    return stocksIdEntityRespository.findByStockCode(code).get(0);
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
  public List<TproductCoinsEntity> saveAllTproductCoinsEntities(List<TproductCoinsEntity> tproductCoinsEntities) {
    return   tproductCoinsEntityRepository.saveAll(tproductCoinsEntities);
  };

  @Override
  public List<TproductStocksEntity> saveAllTproductStocksEntities(List<TproductStocksEntity> tproductStocksEntities) {
    return tproductStocksEntityRepository.saveAll(tproductStocksEntities);
  };

  @Override
  public List<TproductStocksDailyEntity> saveAllTproductStocksDailyEntities(List<TproductStocksDailyEntity> tproductStocksDailyEntities){
    return tproductStocksDailyEntityRepository.saveAll(tproductStocksDailyEntities);
  };

  @Override
  public List<TexCPCoingeckoMKEntity> findAllTexCPCoingeckoMKEntites() {
    return texCPCoingeckoMKEntityRespository.findAll();
  };

  @Override
  public List<TexSkFinnhubQuoteEntity> findAllTexSkFinnhubQuoteEntities() {
    return texSkFinnhubQuoteEntityRepository.findAll();
  };

  @Override
  public List<TexSKFinnhubProfile2Entity> findAllTexSKFinnhubProfile2Entities() {
    return texSKFinnhubProfile2EntityRepository.findAll();
  };

  @Override
  public List<TproductCoinsEntity> findAllTproductCoinsEntities(){
    return tproductCoinsEntityRepository.findAllByOrderByCoinId();
  };

  @Override
  public List<TproductStocksEntity> findAllTprodcutStocksEntities() {
    return tproductStocksEntityRepository.findAll();
  };

  @Override
  public List<TproductStocksDailyEntity> findAllTprodicTproductStocksDailyEntities(){
    return tproductStocksDailyEntityRepository.findAll();
  };

  @Override
  public List<TproductCoinsEntity> findTproductCoinsEntitiesByCoinIdDesc(Long id) {
    return tproductCoinsEntityRepository.findByCoinIdOrderByIdDesc(id);
  };

  @Override
  public List<TproductStocksEntity> findTproductStocksEntitiesByStockIdDesc(Long id) {
    return tproductStocksEntityRepository.findByStockIdOrderByIdDesc(id);
  };

  @Override
  public List<TproductStocksDailyEntity> findTproductStocksDailyEntitiesByStockIdDesc(Long id) {
    return tproductStocksDailyEntityRepository.findByStockIdOrderByIdDesc(id);
  };

  @Override
  public List<TproductStocksDailyEntity> findTproductStocksEntitiesByStockIdOrderByTradeDateAsc(Long id) {
    return tproductStocksDailyEntityRepository.findByStockIdOrderByTradeDateAsc(id);
  };

  @Override
  public TexCPCoingeckoMKEntity findTexCPCoingeckoMKEntityById(Long id) {
    return texCPCoingeckoMKEntityRespository.findById(id).get();
  };

  @Override
  public TexCPCoingeckoMKEntity findLatestTexCPCoingeckoMKEntityByQuoteCoinCode(String code) {
    return texCPCoingeckoMKEntityRespository.findByQuoteCoinCodeOrderByIdDesc(code).get(0);
  };

  @Override
  public TexSkFinnhubQuoteEntity findLatestTexSkFinnhubQuoteEntityByQuoteStockCode(String code) {
    return texSkFinnhubQuoteEntityRepository.findByQuoteStockCodeOrderByIdDesc(code).get(0);
  }; 

  @Override
  public TexSKFinnhubProfile2Entity findLatestTexSKFinnhubProfile2EntityByQuoteStockCode(String code) {
    return texSKFinnhubProfile2EntityRepository.findByQuoteStockCodeOrderByIdDesc(code).get(0);
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
