package com.vtxlab.bootcamp.bcstockfinnhub.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.BcUtil;
import com.vtxlab.bootcamp.bcstockfinnhub.infra.Scheme;
import com.vtxlab.bootcamp.bcstockfinnhub.model.StockProfile2;
import com.vtxlab.bootcamp.bcstockfinnhub.model.StockQuote;
import com.vtxlab.bootcamp.bcstockfinnhub.service.finnhubService;

@Service
public class finnhubServiceHolder implements finnhubService {

  @Value("${api.finnhub.domain}")
  String domain;

  @Value("${api.finnhub.endpoints.quote}")
  String quote;

  @Value("${api.finnhub.endpoints.profile2}")
  String profile2;

  @Value("${api.finnhub.apiKey}")
  String apikey;

  @Autowired
  RestTemplate restTemplate;

  @Override
  public StockQuote getStockQuote(HashMap<String, String> parms) {
    parms.put("token",apikey);
    String url = BcUtil.getUrl(Scheme.HTTPS,domain ,quote, parms);
    return restTemplate.getForObject(url,StockQuote.class);
  }
  
  @Override
  public StockProfile2 getStockProfile2(HashMap<String, String> parms) {
    parms.put("token",apikey);
    String url = BcUtil.getUrl(Scheme.HTTPS,domain ,profile2, parms);
    return restTemplate.getForObject(url,StockProfile2.class);
  }

}
