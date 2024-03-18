package com.vtxlab.bootcamp.bcproductdata.dto.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockProfile2DTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockQuoteDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.model.CoinsMKData;

public class DtoMapper {
  
  public static List<TexCPCoingeckoMKEntity> cpCoingeckoMKEntityMap(List<CoinsMKDataDTO> c) {
    List<TexCPCoingeckoMKEntity> cpCoingeckoMKEntitys = c.stream()
      .map(e -> {
        return TexCPCoingeckoMKEntity.builder()
        //.id(e.getId())
        .quoteDate(LocalDateTime.parse(e.getLastUpdated().substring(0,e.getLastUpdated().length() -1)))
        .quoteCoinCode(e.getSymbol())
        .quoteCurrency("usd")
        .name(e.getName())
        .image(e.getImage())
        .currPrice(e.getCurrentPrice())
        .marketCap(e.getMarketCap())
        .marketCapRank(e.getMarketCapRank())
        .fullyDilutedValuation(e.getFullyDilutedValuation())
        .totalVolume(e.getTotalVolume())
        .high24h(e.getHigh24h())
        .low24h(e.getLow24h())
        .priceChange24h(e.getPriceChange24h())
        .priceChangePct24h(e.getPriceChangePercentage24h())
        .marketCapChange24h(e.getMarketCapChange24h())
        .marketCapChangePct24h(e.getMarketCapChangePercentage24h())
        .circulatingSupply(e.getCirculatingSupply())
        .totalSupply(e.getTotalSupply())
        .maxSupply(e.getMaxSupply())
        .ath(e.getAth())
        .athChangePercentage(e.getAthChangePercentage())
        .athDate(LocalDateTime.parse(e.getAthDate().substring(0,e.getAthDate().length() -1)))
        .atl(e.getAtl())
        .atlChangePercentage(e.getAtlChangePercentage())
        .atlDate(LocalDateTime.parse(e.getAtlDate().substring(0,e.getAtlDate().length() -1)))
        .build();
      })
      .collect(Collectors.toList());

      return cpCoingeckoMKEntitys;
  }

  public static List<TexSkFinnhubQuoteEntity> texSkFinnhubQuoteEntityMap(List<StockQuoteDTO> c
    ,List<String> stocksIdsStrings) {

    Iterator<String> d = stocksIdsStrings.iterator();

    List<TexSkFinnhubQuoteEntity> texSkFinnhubQuoteEntitys = c.stream()
      .map(e -> {
        return TexSkFinnhubQuoteEntity.builder()        
          .quoteDate(LocalDateTime.now())
          .quoteStockCode(d.next())          
          .currPrice(e.getC())
          .priceChg(e.getD())
          .priceChgPct(e.getDp())
          .priceDayHigh(e.getH())
          .priceDayLow(e.getL())
          .priceOpen(e.getO())
          .pricePrevClose(e.getPc())
          .build();
      })
      .collect(Collectors.toList());
      return texSkFinnhubQuoteEntitys;
  }

  public static List<TexSKFinnhubProfile2Entity> texSKFinnhubProfile2EntityMap(List<StockProfile2DTO> c
    ,List<String> stocksIdsStrings) {

    Iterator<String> d = stocksIdsStrings.iterator();
    
    List<TexSKFinnhubProfile2Entity> texSKFinnhubProfile2Entitys = c.stream()
      .map(e -> {
        return TexSKFinnhubProfile2Entity.builder()        
          .quoteDate(LocalDateTime.now())
          .quoteStockCode(d.next())
          .country(e.getCountry())
          .currency(e.getCurrency())
          .estimateCurrency(e.getEstimateCurrency())
          .exchange(e.getExchange())
          .finnhubIndustry(e.getFinnhubIndustry())
          .ipo(e.getIpo())
          .logo(e.getLogo())
          .marketCapitalization(e.getMarketCapitalization())
          .name(e.getName())
          .phone(e.getPhone())
          .shareOutstanding(e.getShareOutstanding())
          .ticker(e.getTicker())
          .weburl(e.getWeburl())
          .build();
      })
      .collect(Collectors.toList());
      return texSKFinnhubProfile2Entitys;
  }

}
