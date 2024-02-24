package com.vtxlab.bootcamp.bccryptocoingecko.service;

import java.util.HashMap;
import java.util.List;
import com.vtxlab.bootcamp.bccryptocoingecko.model.coinsMKData;

public interface CoingeckoService {
  
  List<coinsMKData> getCoinsQuote(HashMap<String,String> uris);

}
