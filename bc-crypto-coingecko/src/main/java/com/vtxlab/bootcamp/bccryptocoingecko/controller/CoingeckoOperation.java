package com.vtxlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bccryptocoingecko.annotation.VsCurrencyCheck;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.response.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.model.CoinsMKData;

@Validated
public interface CoingeckoOperation {
  
  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<CoinsMKDataDTO>> getCoinsQuote(@VsCurrencyCheck @RequestParam(name = "currency", required=true) String currency,
  //ApiResponse<List<CoinsMKDataDTO>> getCoinsQuote(@RequestParam(name = "currency", required=true) String currency, 
                              @RequestParam(name = "ids", required=false) String ids);
                              //@RequestParam(name = "apiKey",required=false, defaultValue = "CG-ZFJ6cHrCuDQm1xoiXe9dm2tG") String apiKey);

  // @GetMapping(value = "/coinslist")
  // List<

}
