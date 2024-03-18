package com.vtxlab.bootcamp.bcproductdata.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  ProductDataService productDataService;

  @Override
  public void run(String ... args) {

    if (productDataService.getAllCoinsIds().size() < 1) {
      productDataService.saveCoinsIds(List.of(CoinsIdEntity.builder().coinId("bitcoin").build()));
    }

    if (productDataService.getAllStocksIds().size() < 1) {
      productDataService.saveStocksIds(List.of(StocksIdEntity.builder().stockId("AAPL").build()));
    }
    

  }
  
}
