package com.vtxlab.bootcamp.bcproductdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRespository;
import com.vtxlab.bootcamp.bcproductdata.service.CoinsIdService;

public class CoinsIdServiceHolder implements CoinsIdService {
 
  @Autowired
  CoinsIdEntityRespository coinsIdEntityRespository;

  @Override
  public CoinsIdEntity saveCoinsId(CoinsIdEntity coinsId) {
    return coinsIdEntityRespository.save(coinsId);
  };

}
