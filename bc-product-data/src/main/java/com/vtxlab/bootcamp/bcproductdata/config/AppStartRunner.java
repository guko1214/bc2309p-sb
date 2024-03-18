package com.vtxlab.bootcamp.bcproductdata.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  ProductDataService productDataService;

  @Override
  public void run(String ... args) {

    if (productDataService.getCoinList().size() < 1) {
      productDataService.saveCoinList(List.of(TproductCoinListEntity.builder().coinCode("bitcoin").build()));
    }

    if (productDataService.getStockList().size() < 1) {
      productDataService.saveStockList(List.of(TproductStockListEntity.builder().stockCode("AAPL").build()));
    }
    

  }
  
}
