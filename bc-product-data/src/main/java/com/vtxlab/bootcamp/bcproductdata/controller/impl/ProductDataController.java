package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bcproductdata.controller.ProductDataOperation;
import com.vtxlab.bootcamp.bcproductdata.dto.mapper.DtoMapper;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductDailyDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductsDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.ApiResponse;
import com.vtxlab.bootcamp.bcproductdata.infra.Syscode;
import com.vtxlab.bootcamp.bcproductdata.model.CoinsMKData;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;
import com.vtxlab.bootcamp.bcproductdata.service.RedisService;

@RestController
@RequestMapping("/data/api/v1")
public class ProductDataController implements ProductDataOperation {

  @Autowired
  ProductDataService productDataService;

  @Autowired
  RedisService redisService;

  @Override
  public ApiResponse<List<TproductsDTO>> getTproductCoinsEntity() {

    List<TproductsDTO> products = DtoMapper.tproductsMapfromTproductCoinsEntity(productDataService.findAllTproductCoinsEntities(),productDataService);
    return ApiResponse.<List<TproductsDTO>>builder()
                 .status(Syscode.OK)
                 .data(products)
                 .build();
  };

  @Override
  public ApiResponse<List<TproductsDTO>> getTproductStocksEntity() {
     
    List<TproductsDTO> products = DtoMapper.tproductsMapfromTproductStocksEntity(productDataService.findAllTprodcutStocksEntities(),productDataService);
    return ApiResponse.<List<TproductsDTO>>builder()
                 .status(Syscode.OK)
                 .data(products)
                 .build();
  };

  @Override
  public ApiResponse<List<TproductsDTO>> getTproductsEntity() {
    List<TproductsDTO> coins = DtoMapper.tproductsMapfromTproductCoinsEntity(productDataService.findAllTproductCoinsEntities(),productDataService);
    List<TproductsDTO> stocks = DtoMapper.tproductsMapfromTproductStocksEntity(productDataService.findAllTprodcutStocksEntities(),productDataService);
    List<TproductsDTO> products = new ArrayList<>();
    products.addAll(coins);
    products.addAll(stocks);
    return ApiResponse.<List<TproductsDTO>>builder()
                 .status(Syscode.OK)
                 .data(products)
                 .build();
  };

  @Override
  public ApiResponse<List<TproductDailyDTO>> getTproductStocksDailyEntity(String stockCode)  throws JsonProcessingException {
    System.out.println("stockcode: " + stockCode);
    TproductStockListEntity tproductStockListEntity = productDataService.getStockListByCode(stockCode);
    Long stockId = tproductStockListEntity.getId();
    List<TproductStocksDailyEntity> tproductStocksDailyEntities = redisService.bulkGetStocksDaily(stockId);
    if (tproductStocksDailyEntities.size() == 0) {
      tproductStocksDailyEntities =productDataService.findTproductStocksEntitiesByStockIdOrderByTradeDateAsc(stockId);
      if (tproductStocksDailyEntities.size() == 0) {
        throw new RestClientException("RestClientException - Product Data Service is unavailable");
      }
      redisService.bulkCreateStocksDaily(tproductStocksDailyEntities);
    }
    List<TproductDailyDTO> productDaily = DtoMapper.tproductDailyMapfromTproductStocksDailyEntity(
      tproductStocksDailyEntities, productDataService);
    return ApiResponse.<List<TproductDailyDTO>>builder()
    .status(Syscode.OK)
    .data(productDaily)
    .build();
  };

  @Override
  public ApiResponse<List<CoinsMKDataDTO>> getApiResonseCoinsMKDataDTO() {
    List<CoinsMKDataDTO> coinsMKDatas = DtoMapper.texCPCoingeckoMKEntityMap(productDataService.findAllTexCPCoingeckoMKEntites());

    return ApiResponse.<List<CoinsMKDataDTO>>builder()
    .status(Syscode.OK)
    .data(coinsMKDatas.subList(coinsMKDatas.size()-14, coinsMKDatas.size()))
    .build();
  }

}
