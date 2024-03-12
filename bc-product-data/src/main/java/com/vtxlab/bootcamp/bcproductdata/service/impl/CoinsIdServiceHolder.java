package com.vtxlab.bootcamp.bcproductdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.repostitory.CoinsIdEntityRespository;
import com.vtxlab.bootcamp.bcproductdata.service.CoinsIdService;

@Service
public class CoinsIdServiceHolder implements CoinsIdService {
 
  @Autowired
  CoinsIdEntityRespository coinsIdEntityRespository;

  @Override
  public List<CoinsIdEntity> saveCoinsIds(List<CoinsIdEntity> coinsIds) {
    return coinsIdEntityRespository.saveAll(coinsIds);
  };

}