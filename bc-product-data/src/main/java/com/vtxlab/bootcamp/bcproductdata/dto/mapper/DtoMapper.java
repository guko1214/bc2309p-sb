package com.vtxlab.bootcamp.bcproductdata.dto.mapper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockProfile2DTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockQuoteDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductDailyDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.response.TproductsDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity.TproductCoinsEntityBuilder;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity.TproductStocksDailyEntityBuilder;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity.TproductStocksEntityBuilder;
import com.vtxlab.bootcamp.bcproductdata.model.CoinsMKData;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

public class DtoMapper {
  
  public static List<TexCPCoingeckoMKEntity> cpCoingeckoMKEntityMap(List<CoinsMKDataDTO> c) {
    List<TexCPCoingeckoMKEntity> cpCoingeckoMKEntitys = c.stream()
      .map(e -> {
        //System.out.println("coin name: " + e.getName());
        return TexCPCoingeckoMKEntity.builder()
        //.id(e.getId())
        .quoteDate(LocalDateTime.parse(e.getLastUpdated().substring(0,e.getLastUpdated().length() -1)))
        .quoteCoinCode(e.getId())
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
    ,String stockCode) {

    List<TexSkFinnhubQuoteEntity> texSkFinnhubQuoteEntitys = c.stream()
      .map(e -> {
        return TexSkFinnhubQuoteEntity.builder()        
          .quoteDate(LocalDateTime.now())
          .quoteStockCode(stockCode)          
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
    ,String stockCode) {

    // Iterator<String> d = stocksIdsStrings.iterator();
    
    List<TexSKFinnhubProfile2Entity> texSKFinnhubProfile2Entitys = c.stream()
      .map(e -> {
        return TexSKFinnhubProfile2Entity.builder()        
          .quoteDate(LocalDateTime.now())
          .quoteStockCode(stockCode)
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

  public static List<TproductCoinsEntity> tproductCoinsEntityMap(
     List<TproductCoinListEntity> coinList, ProductDataService productDataService) {

    List<TproductCoinsEntity> tproductCoinsEntities = coinList.stream()
          .map(
          s -> {
            Long tproductCoinsEntityId;
            List<TproductCoinsEntity> u = productDataService.findTproductCoinsEntitiesByCoinIdDesc(s.getId());
            if (u.size() == 0) {
              tproductCoinsEntityId = null;
            } else {
              tproductCoinsEntityId = u.get(0).getId();
            }
            TexCPCoingeckoMKEntity e = productDataService.findLatestTexCPCoingeckoMKEntityByQuoteCoinCode(s.getCoinCode());
            TproductCoinsEntityBuilder tproductCoinsEntitybuilder = TproductCoinsEntity.builder()                
                .coinId(s.getId())
                .name(e.getName())
                .currentPrice(e.getCurrPrice())
                .priceChgPct(e.getPriceChange24h())
                .marketCap(e.getMarketCap())
                .logo(e.getImage());
                
            if (tproductCoinsEntityId != null)
              tproductCoinsEntitybuilder.id(tproductCoinsEntityId);
            return tproductCoinsEntitybuilder.build();
        
        }).collect(Collectors.toList());
      return tproductCoinsEntities;
  }

  public static List<TproductStocksEntity> tproductStocksEntityMap(List<TproductStockListEntity> stockList, ProductDataService productDataService) {

    List<TproductStocksEntity> tproductStocksEntities = stockList.stream()
        .map(
          s -> {
            Long tproductStocksEntityId;
            List<TproductStocksEntity> u = productDataService.findTproductStocksEntitiesByStockIdDesc(s.getId());
            if (u.size() == 0) {
              tproductStocksEntityId = null;
            } else {
              tproductStocksEntityId = u.get(0).getId();
            }
            TexSkFinnhubQuoteEntity e = productDataService.findLatestTexSkFinnhubQuoteEntityByQuoteStockCode(s.getStockCode());
            TexSKFinnhubProfile2Entity k = productDataService.findLatestTexSKFinnhubProfile2EntityByQuoteStockCode(s.getStockCode());
            TproductStocksEntityBuilder tproductStocksEntityBuilder = TproductStocksEntity.builder()              
              .stockId(s.getId())
              .name(k.getName())
              .currentPrice(e.getCurrPrice())
              .priceChgPct(e.getPriceChgPct())
              .marketCap(k.getMarketCapitalization())
              .logo(k.getLogo());
            if (tproductStocksEntityId != null)
              tproductStocksEntityBuilder.id(tproductStocksEntityId);
            return tproductStocksEntityBuilder.build();
          }).collect(Collectors.toList());

    return tproductStocksEntities;
  }

  public static List<TproductStocksDailyEntity> tproductStocksDailyEntityMap(List<TproductStockListEntity> stockList, ProductDataService productDataService) {
    List<TproductStocksDailyEntity> tproductStocksDailyEntities = stockList.stream()
    .map(
      s -> {
        Long tproductStocksDailyEntityId;
        List<TproductStocksDailyEntity> u = productDataService.findTproductStocksDailyEntitiesByStockIdDesc(s.getId());
        if (u.size() == 0) {
          tproductStocksDailyEntityId = null;
        } else {
          tproductStocksDailyEntityId = u.get(0).getId();
        }
        TexSkFinnhubQuoteEntity e = productDataService.findLatestTexSkFinnhubQuoteEntityByQuoteStockCode(s.getStockCode());
        //TexSKFinnhubProfile2Entity k = productDataService.findLatestTexSKFinnhubProfile2EntityByQuoteStockCode(s.getStockCode());
        TproductStocksDailyEntityBuilder tproductStocksDailyEntityBuilder = TproductStocksDailyEntity.builder()              
          .stockId(s.getId())
          .tradeDate(LocalDate.now().toString())
          .dayHigh(e.getPriceDayHigh())
          .dayLow(e.getPriceDayLow())
          .dayOpen(e.getPriceOpen())
          .dayClose(e.getCurrPrice())
          .updateTime(LocalDateTime.now())
          ;
        // if (tproductStocksDailyEntityId != null)
        //   tproductStocksDailyEntityBuilder.id(tproductStocksDailyEntityId);
        return tproductStocksDailyEntityBuilder.build();
      }).collect(Collectors.toList());

      return tproductStocksDailyEntities;
  }

  public static List<TproductsDTO> tproductsMapfromTproductCoinsEntity(List<TproductCoinsEntity> coinsEntities, 
  ProductDataService productDataService) {
    return coinsEntities.stream()
      .map(e -> {

        TproductCoinListEntity coinList = productDataService.getCoinListById(e.getCoinId());
        return TproductsDTO.builder()
          .productId(coinList.getCoinCode())
          .name(e.getName())
          .currentPrice(e.getCurrentPrice())
          .priceChgPct(e.getPriceChgPct())
          .marketCap(e.getMarketCap())
          .logo(e.getLogo())
          .build();
      })
      .collect(Collectors.toList());
  }

  public static List<TproductsDTO> tproductsMapfromTproductStocksEntity(List<TproductStocksEntity> stocksEntities,
  ProductDataService productDataService) {
    return stocksEntities.stream()
      .map(e -> {

        TproductStockListEntity stockList = productDataService.getStockListById(e.getStockId());
        return TproductsDTO.builder()
          .productId(stockList.getStockCode())
          .name(e.getName())
          .currentPrice(e.getCurrentPrice())
          .priceChgPct(e.getPriceChgPct())
          .marketCap(e.getMarketCap())
          .logo(e.getLogo())
          .build();
      })
      .collect(Collectors.toList());
  }

  public static List<TproductDailyDTO> tproductDailyMapfromTproductStocksDailyEntity(List<TproductStocksDailyEntity> stocksDailyEntities,
  ProductDataService productDataService) {
    return stocksDailyEntities.stream()
      .map(e -> {

        TproductStockListEntity stockList = productDataService.getStockListById(e.getStockId());
        return TproductDailyDTO.builder()
          .productId(stockList.getStockCode())
          .tradeDate(e.getTradeDate().toString())
          .dayHigh(e.getDayHigh())
          .dayLow(e.getDayLow())
          .dayOpen(e.getDayOpen())
          .dayClose(e.getDayClose())
          .build();
      })
      .collect(Collectors.toList());
  }

  public static List<CoinsMKDataDTO> texCPCoingeckoMKEntityMap(List<TexCPCoingeckoMKEntity> c) {
    List<CoinsMKDataDTO> cpCoingeckoMKEntitys = c.stream()
      .map(e -> {
        //System.out.println("coin name: " + e.getName());
        return CoinsMKDataDTO.builder()
        //.id(e.getId())
        //.quoteDate()
        .id(e.getQuoteCoinCode())
        //.quoteCurrency("usd")
        .name(e.getName())
        .image(e.getImage())
        .currentPrice(e.getCurrPrice())
        .marketCap(e.getMarketCap())
        .marketCapRank(e.getMarketCapRank())
        .fullyDilutedValuation(e.getFullyDilutedValuation())
        .totalVolume(e.getTotalVolume())
        .high24h(e.getHigh24h())
        .low24h(e.getLow24h())
        .priceChange24h(e.getPriceChange24h())
        .priceChangePercentage24h(e.getPriceChangePct24h())
        .marketCapChange24h(e.getMarketCapChange24h())
        .marketCapChangePercentage24h(e.getMarketCapChangePct24h())
        .circulatingSupply(e.getCirculatingSupply())
        .totalSupply(e.getTotalSupply())
        .maxSupply(e.getMaxSupply())
        .ath(e.getAth())
        .athChangePercentage(e.getAthChangePercentage())
        .athDate(e.getAthDate().toString())
        .atl(e.getAtl())
        .atlChangePercentage(e.getAtlChangePercentage())
        .atlDate(e.getAtlDate().toString())
        .build();
      })
      .collect(Collectors.toList());

      return cpCoingeckoMKEntitys;
  }

}
