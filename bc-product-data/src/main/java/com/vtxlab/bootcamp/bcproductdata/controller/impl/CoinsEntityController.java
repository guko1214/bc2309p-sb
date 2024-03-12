package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bcproductdata.controller.CoinsIdEntityOperation;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtxlab.bootcamp.bcproductdata.service.CoinsIdService;

@RestController
@RequestMapping(value = "/data/api/v1")
public class CoinsEntityController implements CoinsIdEntityOperation {
  
  @Autowired
  CoinsIdService coinsIdService;

  @Override
  public List<CoinsIdEntity> saveCoinsIds(String coinsIdList) {    
    List<String> coinIdsList =  BcUtil.csvToList(coinsIdList);
    List<String> existingCoinIdIdEntityList = coinsIdService.getAllCoinsIds().stream()
            .map(e -> e.getCoinId())
            .collect(Collectors.toList());

    List<CoinsIdEntity> coinsIdEntityList = coinIdsList.stream()
                .filter(e -> !(existingCoinIdIdEntityList.contains(e)))
                .map(e -> {
                  return CoinsIdEntity.builder()
                          .coinId(e)
                          .build();
                })
                .collect(Collectors.toList());

    coinsIdService.saveCoinsIds(coinsIdEntityList);
    return coinsIdEntityList;
  };

}
