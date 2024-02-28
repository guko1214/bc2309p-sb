package com.vtxlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.response.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.ParamConverter;
import com.vtxlab.bootcamp.bccryptocoingecko.infra.RedisHelper;
import com.vtxlab.bootcamp.bccryptocoingecko.model.VsCurrency;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;
import com.vtxlab.bootcamp.bccryptocoingecko.service.RedisService;

@Service
public class RedisServiceimpl implements RedisService{
  
  @Autowired
  RedisHelper redisHelper;

  @Autowired
  CoingeckoService coingeckoService;

  public CoinsMKDataDTO createCoinsMkData(String key, CoinsMKDataDTO coinsMKData) throws JsonProcessingException {
    redisHelper.set(key,coinsMKData);
    return coinsMKData;
  };

  public List<CoinsMKDataDTO> bulkCreateCoinsMKData(List<CoinsMKDataDTO> coinsMKDataDTOs, VsCurrency currency) throws JsonProcessingException{
    Iterator<CoinsMKDataDTO> iterator = coinsMKDataDTOs.iterator();
    while (iterator.hasNext()) {
      CoinsMKDataDTO d = iterator.next();
      this.createCoinsMkData("crypto:coingecko:coins-markets:" + currency.getId() + ":" + d.getId() , d);
    }
    return coinsMKDataDTOs;
  }

  public CoinsMKDataDTO getCoinsMkData(String key) throws JsonProcessingException {
    return redisHelper.get(key, CoinsMKDataDTO.class);
  };

  public List<CoinsMKDataDTO> bulkGetCoinsMKDataDTOs(VsCurrency currency, String ids) throws JsonProcessingException {
    List<String> idsList = new ArrayList<>();
    if (ids != null) {
      idsList = ParamConverter.csvToList(ids);
      System.out.println("size = " + idsList.size());
      List<CoinsMKDataDTO>  coinsMKDataDTOs = idsList.stream()
      .map(e -> {
        try {
        return this.getCoinsMkData("crypto:coingecko:coins-markets:" + currency.getId() + ":" + e);
        } catch (JsonProcessingException e1) {
        throw new RuntimeException();
        }
      })
      .collect(Collectors.toList());
      return coinsMKDataDTOs;
    } else {
      
      idsList = redisHelper.getKeys("crypto:coingecko:coins-markets:*");
      List<CoinsMKDataDTO>  coinsMKDataDTOs = idsList.stream()
      .map(e -> {
        try {
        return this.getCoinsMkData(e);
        } catch (JsonProcessingException e1) {
        throw new RuntimeException();
        }
      })
      .collect(Collectors.toList());
      return coinsMKDataDTOs;
    }
    //System.out.println(idsList);

    // List<CoinsMKDataDTO> coinsMKDataDTOs = new ArrayList<>();
    // ListIterator<String> iterator = idsList.listIterator();
    // while (iterator.hasNext()) {
    //   System.out.println("iterator " +iterator.next());
    //   coinsMKDataDTOs.add(this.getCoinsMkData("crypto:coingecko:coins-markets:" + currency.getId() + ":" + iterator.next()));
    // }
    // System.out.println(coinsMKDataDTOs);
    
    
  };

}
