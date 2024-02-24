package com.vtxlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bccryptocoingecko.model.coinsMKData;

public interface CoingeckoOperation {
  
  @GetMapping(value = "/coins")
  List<coinsMKData> getCoinsQuote(@RequestParam(name = "currency", required=true) String currency, 
                              @RequestParam(name = "ids", required=false) String ids,
                              @RequestParam(name = "apiKey",required=false, defaultValue = "CG-ZFJ6cHrCuDQm1xoiXe9dm2tG") String apiKey);

  // @GetMapping(value = "/coinslist")
  // List<

}
