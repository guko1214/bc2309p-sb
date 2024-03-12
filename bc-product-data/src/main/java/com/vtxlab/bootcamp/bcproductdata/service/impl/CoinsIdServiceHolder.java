package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRepository;
import com.vtxlab.bootcamp.bcproductdata.service.CoinsIdService;

@Service
public class CoinsIdServiceHolder implements CoinsIdService {
 
  @Autowired
  CoinsIdEntityRepository coinsIdEntityRespository;

  @Override
  public List<CoinsIdEntity> saveCoinsIds(List<CoinsIdEntity> coinsIds) {
    return coinsIdEntityRespository.saveAll(coinsIds);
  };

  @Override
  public List<CoinsIdEntity> getAllCoinsIds() {
    return coinsIdEntityRespository.findAll();
  };

}