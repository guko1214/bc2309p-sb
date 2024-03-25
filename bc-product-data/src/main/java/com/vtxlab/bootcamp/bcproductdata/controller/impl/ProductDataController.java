package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bcproductdata.controller.ProductDataOperation;
import com.vtxlab.bootcamp.bcproductdata.dto.mapper.DtoMapper;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductDailyDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductsDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.ApiResponse;
import com.vtxlab.bootcamp.bcproductdata.infra.Syscode;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@RestController
@RequestMapping("/data/api/v1")
public class ProductDataController implements ProductDataOperation {

  @Autowired
  ProductDataService productDataService;

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
  public ApiResponse<List<TproductDailyDTO>> getTproductStocksDailyEntity(String stockcode) {
    TproductStockListEntity tproductStockListEntity = productDataService.getStockListByCode(stockcode);
    List<TproductDailyDTO> productDaily = DtoMapper.tproductDailyMapfromTproductStocksDailyEntity(
      productDataService.findTproductStocksEntitiesByStockIdOrderByTradeDateAsc(tproductStockListEntity.getId()), productDataService);
    return ApiResponse.<List<TproductDailyDTO>>builder()
    .status(Syscode.OK)
    .data(productDaily)
    .build();
  };

}
