package com.vtxlab.bootcamp.bcstockfinnhub.service;

import java.util.HashMap;
import com.vtxlab.bootcamp.bcstockfinnhub.model.StockProfile2;
import com.vtxlab.bootcamp.bcstockfinnhub.model.StockQuote;

public interface finnhubService {
  
  StockQuote getStockQuote(HashMap<String, String> parms);

  StockProfile2 getStockProfile2(HashMap<String, String> parms);

}
