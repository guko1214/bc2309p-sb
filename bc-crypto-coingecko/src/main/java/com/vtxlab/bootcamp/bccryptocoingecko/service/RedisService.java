package com.vtxlab.bootcamp.bccryptocoingecko.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.vtxlab.bootcamp.bccryptocoingecko.dto.response.CoinsMKDataDTO;

public interface RedisService {
  
  List<CoinsMKDataDTO> createCoinsMkDataList(String key, List<CoinsMKDataDTO> coinsMKDatas) throws JsonProcessingException;

  List<CoinsMKDataDTO> getCoinsMkDataList(String key) throws JsonProcessingException;

}
