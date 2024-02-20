package com.vtxlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Crypto;

public interface CoingeckoOperation {
  
  @GetMapping(value = "/coins")
  List<Crypto> getCoinsQuote(@RequestParam(name = "currency", required=true) String currency, 
                              @RequestParam(name = "ids", required=false) String ids);

}
