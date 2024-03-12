package com.vtxlab.bootcamp.bcproductdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;
import java.util.List;
import org.springframework.http.HttpStatus;

public interface CoinsIdEntityOperation {
  
  @PostMapping(value = "/coinsid")
  @ResponseStatus(value = HttpStatus.OK)
  List<CoinsIdEntity> saveCoinsIds(@RequestParam(value = "coinsids") String coinsIdList);

}
