package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.StocksIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.service.StocksIdService;

@Service
public class StocksIdServiceHolder implements StocksIdService {
  
  @Autowired
  StocksIdEntityRepository stocksIdEntityRespository;

  @Override
  public List<StocksIdEntity> saveStocksIds(List<StocksIdEntity> stocksIds) {
    return stocksIdEntityRespository.saveAll(stocksIds);
  };

  @Override
  public List<StocksIdEntity> getAllStockIds() {
    return stocksIdEntityRespository.findAll();
  };

}
