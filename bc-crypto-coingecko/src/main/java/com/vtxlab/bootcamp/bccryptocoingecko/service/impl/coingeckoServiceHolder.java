package com.vtxlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.BcUtil;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.Scheme;
import com.vtxlab.bootcamp.bccryptocoingecko.model.coinsMKData;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;

@Service
public class CoingeckoServiceHolder implements CoingeckoService {
 
  @Value("${api.coinsGecko.domain}")
  private String domain;

  @Value("${api.coinsGecko.endpoints.coinsList}")
  private String coinsList;

  @Value("${api.coinsGecko.endpoints.coinsMarketData}")
  private String coinsMarketData;

  @Value("${api.coinsGecko.apiKey}")
  private String apiKey;

  @Autowired
  private RestTemplate restTemplate;


  @Override
  public List<coinsMKData> getCoinsQuote(HashMap<String,String> uris) {
    
    //String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-ZFJ6cHrCuDQm1xoiXe9dm2tG";
    String url = BcUtil.getUrl(Scheme.HTTPS,domain,coinsMarketData,uris);
    //restTemplate.getForObject(url, coinsMKData[].class);
    coinsMKData[] cryptos = restTemplate.getForObject(url, coinsMKData[].class);
    return Arrays.stream(cryptos).collect(Collectors.toList());
  }


}
