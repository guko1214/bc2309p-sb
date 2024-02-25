package com.vtxlab.bootcamp.bccryptocoingecko.controller.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bccryptocoingecko.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.mapper.CoinGeckoMapper;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.response.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ApiResponse;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.Syscode;
import com.vtxlab.bootcamp.bccryptocoingecko.model.CoinsMKData;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {
  
  @Autowired
  CoingeckoService coingeckoService;
  
  @Override
  public ApiResponse<List<CoinsMKDataDTO>> getCoinsQuote(String currency, String ids){
    HashMap<String, String> parm = new HashMap<>();
    parm.put("vs_currency",currency);
    parm.put("ids",ids);

    List<CoinsMKData> coinsMKData = coingeckoService.getCoinsQuote(parm);

    return ApiResponse.<List<CoinsMKDataDTO>>builder()
    .status(Syscode.OK)
    .data(CoinGeckoMapper.coinsMKDataDTOMap(coinsMKData))
    .build();
  }

  
}
