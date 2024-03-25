package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.RedisHelper;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;
import com.vtxlab.bootcamp.bcproductdata.service.RedisService;

public class RedisServiceimpl implements RedisService {
  
  @Autowired
  RedisHelper redisHelper;

  @Autowired
  ProductDataService productDataService;

  // @Override
  // public TproductStocksDailyEntity createStocksDaily(String key, TproductStocksDailyEntity tproductStocksDailyEntity) throws JsonProcessingException {
   

  //   return tproductStocksDailyEntity;
  // };

  @Override
  public List<TproductStocksDailyEntity> bulkCreateStocksDaily(List<TproductStocksDailyEntity> tproductStocksDailyEntities) throws JsonProcessingException {    
    if (tproductStocksDailyEntities.size() > 0) {      
      Long stockId = tproductStocksDailyEntities.get(0).getStockId();
      List<String> idsList = redisHelper.getKeys("stock:daily:" + stockId);
      if (idsList.size() > 0 ) {
        redisHelper.delete(idsList);
      }
      List<String> updateDatesList = redisHelper.getKeys("stock:daily:" + stockId + ":updatedDate");
      if (updateDatesList.size() > 0 ) {
        redisHelper.delete(updateDatesList);
      } 
      TproductStocksDailyEntity[] tproductStocksDailyEntityArr = tproductStocksDailyEntities.stream()
        .toArray(TproductStocksDailyEntity[]::new);
      redisHelper.set("stock:daily:" + stockId, tproductStocksDailyEntityArr);
      redisHelper.set("stock:daily:" + stockId + ":updatedDate", LocalDate.now().toString());
    }
    return tproductStocksDailyEntities;
  };

  // public TproductStocksDailyEntity getStocksDaily(String key) throws JsonProcessingException {

  //   throw new RestClientException("RestClientException - Coingecko Service is unavailable");
  // };

  public List<TproductStocksDailyEntity> bulkGetStocksDaily(Long stockId) throws JsonProcessingException {
    List<String> idsList = redisHelper.getKeys("stock:daily:" + stockId);
    if (idsList.size() > 0) {
      if (LocalDate.parse(redisHelper.get("stock:daily:" + stockId + ":updatedDate",String.class)).plusDays(1).isAfter(LocalDate.now())) {
        TproductStocksDailyEntity[] TproductStocksDailyEntitiesArr = redisHelper.get("stock:daily:" + stockId, TproductStocksDailyEntity[].class);
        return Arrays.stream(TproductStocksDailyEntitiesArr).collect(Collectors.toList());
      } 
    }
    //throw new RestClientException("RestClientException - Product Data Service is unavailable");
    return new ArrayList<>();
  };

  public List<String> getRedisKeys() {
    return redisHelper.getKeys("stock:daily:*").stream()
      .map(e -> {
        return e.replace("stock:daily:","");
      }).collect(Collectors.toList());
  };
}
