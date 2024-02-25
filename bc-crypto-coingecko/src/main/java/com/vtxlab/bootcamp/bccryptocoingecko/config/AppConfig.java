package com.vtxlab.bootcamp.bccryptocoingecko.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bccryptocoingecko.model.VsCurrency;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoingeckoServiceHolder;

@Configuration
public class AppConfig {

  // @Autowired
  // private CoingeckoService coingeckoService;

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // @Bean
  // List<VsCurrency> supportedVsCurrencies() {
  //   //CoingeckoService coingeckoService2 = new CoingeckoServiceHolder();
  //   return coingeckoService.getSupporedVsCurrencies();
  // }
  
}
