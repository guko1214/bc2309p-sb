package com.vtxlab.bootcamp.bcproductdata.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bcproductdata.dto.mapper.DtoMapper;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockProfile2DTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockQuoteDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtxlab.bootcamp.bcproductdata.infra.Scheme;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@Configuration
@EnableScheduling
public class ScheduleConfig {
  
  @Value("${api.bc-crypto-coingecko.domain}")
  private String coingeckoDomain;

  @Value("${api.bc-crypto-coingecko.port}")
  private String coingeckoPort;

  @Value("${api.bc-crypto-coingecko.apiVersion}")
  private String coingeckoApiVersion;

  @Value("${api.bc-crypto-coingecko.endpoints.coinMarket}")
  private String coingeckoCoinMarket;

  @Value("${api.bc-stock-finnhub.domain}")
  private String finnhubDomain;

  @Value("${api.bc-stock-finnhub.port}")
  private String finnhubPort;

  @Value("${api.bc-stock-finnhub.apiVersion}")
  private String finnhubapiVersion;

  @Value("${api.bc-stock-finnhub.endpoints.quote}")
  private String finnhubQuote;
  
  @Value("${api.bc-stock-finnhub.endpoints.profile2}")
  private String finnhubProfile2;

  @Autowired
  ProductDataService productDataService;

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  ObjectMapper objectMapper;

  @Scheduled(fixedRate = 600000) // 3000ms = 3s
  public void getBcCpCoingeckoCoinsMK() throws InterruptedException, JsonProcessingException {
    HashMap<String, String> uris = new HashMap<>();
    List<TproductCoinListEntity> coinListEntities = productDataService.getCoinList();
    List<String> coinCodeStrings = coinListEntities.stream()
                                //.filter(e -> e != null)
                                .map(e -> e.getCoinCode())
                                .collect(Collectors.toList());
    String coinsIdsCsv = BcUtil.listToCsv(coinCodeStrings);
    uris.put("currency","usd");
    uris.put("ids",coinsIdsCsv);
    
    String url = BcUtil.getUrl(Scheme.HTTP,coingeckoDomain    
                                ,coingeckoPort,coingeckoApiVersion+coingeckoCoinMarket,uris);

    String apiResponse = restTemplate.getForObject(url, String.class);
    JsonNode jsonArray = objectMapper.readTree(apiResponse);
    List<CoinsMKDataDTO> coinsMKDataDTOs = new ArrayList<>();
    for (JsonNode jsonNode : jsonArray.get("data")) {      
      coinsMKDataDTOs.add(objectMapper.readValue(jsonNode.toString(),CoinsMKDataDTO.class));
    }
    List<TexCPCoingeckoMKEntity> cryptosEntitiesList = DtoMapper.cpCoingeckoMKEntityMap(coinsMKDataDTOs);
    productDataService.saveAllTexCPCoingeckoMKEntites(cryptosEntitiesList);

  }


  @Scheduled(fixedRate = 600000) // 3000ms = 3s
  public void getSkFinnhubQuote() throws InterruptedException, JsonProcessingException {
    HashMap<String, String> uris = new HashMap<>();
    List<TproductStockListEntity> stockListEntities = productDataService.getStockList();
    List<String> stockCodeStrings = stockListEntities.stream()
                                //.filter(e -> e != null)
                                .map(e -> e.getStockCode())
                                .collect(Collectors.toList());
    String stocksIdsCsv = BcUtil.listToCsv(stockCodeStrings);
    uris.put("symbol",stocksIdsCsv);

    String url = BcUtil.getUrl(Scheme.HTTP,finnhubDomain    
                                ,finnhubPort,finnhubapiVersion+finnhubQuote,uris);
    System.out.println(url);
    String apiResponse = restTemplate.getForObject(url, String.class);
    JsonNode jsonArray = objectMapper.readTree(apiResponse);
    List<StockQuoteDTO> stocksMKDataDTOs = new ArrayList<>();
    for (JsonNode jsonNode : jsonArray.get("data")) {      
      stocksMKDataDTOs.add(objectMapper.readValue(jsonNode.toString(),StockQuoteDTO.class));
    }
    List<TexSkFinnhubQuoteEntity> stockQuotesEntitiesList = DtoMapper.texSkFinnhubQuoteEntityMap(stocksMKDataDTOs,stockCodeStrings);
    productDataService.saveAllTexSkFinnhubQuoteEntities(stockQuotesEntitiesList);
  }

  @Scheduled(fixedRate = 600000) // 3000ms = 3s
  public void getSkFinnhubProfile2() throws InterruptedException, JsonProcessingException {
    HashMap<String, String> uris = new HashMap<>();
    List<TproductStockListEntity> stockListEntities = productDataService.getStockList();
    List<String> stockCodeStrings = stockListEntities.stream()
                                //.filter(e -> e != null)
                                .map(e -> e.getStockCode())
                                .collect(Collectors.toList());
    String stocksIdsCsv = BcUtil.listToCsv(stockCodeStrings);
    uris.put("symbol",stocksIdsCsv);

    String url = BcUtil.getUrl(Scheme.HTTP,finnhubDomain    
                                ,finnhubPort,finnhubapiVersion+finnhubProfile2,uris);
    System.out.println(url);
    String apiResponse = restTemplate.getForObject(url, String.class);
    JsonNode jsonArray = objectMapper.readTree(apiResponse);
    List<StockProfile2DTO> stocksProfile2DTOs = new ArrayList<>();
    for (JsonNode jsonNode : jsonArray.get("data")) {      
      stocksProfile2DTOs.add(objectMapper.readValue(jsonNode.toString(),StockProfile2DTO.class));
    }
    List<TexSKFinnhubProfile2Entity> stockProfile2sEntitiesList = DtoMapper.texSKFinnhubProfile2EntityMap(stocksProfile2DTOs,stockCodeStrings);
    productDataService.saveAllTexSKFinnhubProfile2Entities(stockProfile2sEntitiesList);
  }

  @Scheduled(cron = "0 23 0 * * *")
  public void deleteTexternalCryptoCoingeckoMK() {
    productDataService.deleteAllTexCPCoingeckoMKEntites();
  }

  @Scheduled(cron = "0 23 0 * * *")
  public void deleteTexternalStockFinnhubQuote() {
    productDataService.deleteAllTexSkFinnhubQuoteEntities();
  }

  @Scheduled(cron = "0 23 0 * * *")
  public void deleteTexternalStockFinnhubProfile2() {
    productDataService.deleteAllTexSKFinnhubProfile2Entitiess();
  }  
}
