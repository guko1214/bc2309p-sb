package com.vtxlab.bootcamp.bccryptocoingecko.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bccryptocoingecko.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Crypto;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {
  
  @Autowired
  CoingeckoService coingeckoService;
  
  @Override
  public List<Crypto> getCoinsQuote(String currency, String ids){
    return coingeckoService.getCoinsQuote();
  }
  
}
