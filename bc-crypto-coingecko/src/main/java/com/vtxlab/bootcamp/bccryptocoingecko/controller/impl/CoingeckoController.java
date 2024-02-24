package com.vtxlab.bootcamp.bccryptocoingecko.controller.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bccryptocoingecko.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.bccryptocoingecko.model.coinsMKData;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {
  
  @Autowired
  CoingeckoService coingeckoService;
  
  @Override
  public List<coinsMKData> getCoinsQuote(String currency, String ids,String apiKey){
    HashMap<String, String> parm = new HashMap<>();
    parm.put("vs_currency",currency);
    parm.put("ids",ids);
    parm.put("x_cg_demo_api_key",apiKey);
    return coingeckoService.getCoinsQuote(parm);
  }
  
}
