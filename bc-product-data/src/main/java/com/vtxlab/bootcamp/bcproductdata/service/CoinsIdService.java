package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;

public interface CoinsIdService {
  
  List<CoinsIdEntity> saveCoinsIds(List<CoinsIdEntity> coinsIds);

  List<CoinsIdEntity> getAllCoinsIds();

}
