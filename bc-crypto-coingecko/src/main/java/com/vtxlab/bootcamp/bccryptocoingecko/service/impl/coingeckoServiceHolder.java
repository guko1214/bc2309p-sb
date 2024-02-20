package com.vtxlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Crypto;
import com.vtxlab.bootcamp.bccryptocoingecko.service.coingeckoService;

public class coingeckoServiceHolder implements coingeckoService {
 
  public List<Crypto> getCoins() {
    String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=YOUR-API-KEY"
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getForObject(url, Crypto[].class);
    Crypto[] cryptos = restTemplate.getForObject(url, Crypto[].class);
    return Arrays.stream(cryptos).collect(Collectors.toList());
  }


}
