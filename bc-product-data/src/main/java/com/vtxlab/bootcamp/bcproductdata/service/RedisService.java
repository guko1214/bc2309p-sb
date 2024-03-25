package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;

public interface RedisService {
  
  //TproductStocksDailyEntity createStocksDaily(String key, TproductStocksDailyEntity tproductStocksDailyEntity) throws JsonProcessingException;

  List<TproductStocksDailyEntity> bulkCreateStocksDaily(List<TproductStocksDailyEntity> tproductStocksDailyEntities) throws JsonProcessingException;

  //TproductStocksDailyEntity getStocksDaily(String key) throws JsonProcessingException;

  List<TproductStocksDailyEntity> bulkGetStocksDaily(Long stockId) throws JsonProcessingException;

  List<String> getRedisKeys();

}
