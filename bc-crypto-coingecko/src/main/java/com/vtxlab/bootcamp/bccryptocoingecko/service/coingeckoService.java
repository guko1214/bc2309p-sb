package com.vtxlab.bootcamp.bccryptocoingecko.service;

import java.util.List;
import com.vtxlab.bootcamp.bccryptocoingecko.model.Crypto;

public interface coingeckoService {
  
  List<Crypto> getCoins();

}
