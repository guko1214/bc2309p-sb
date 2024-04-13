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
import com.vtxlab.bootcamp.bcproductdata.dto.request.ApiResponseCoinMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.ApiResponseStockProfile2DTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.ApiResponseStockQuoteDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockProfile2DTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockQuoteDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;
import com.vtxlab.bootcamp.bcproductdata.infra.ApiResponse;
import com.vtxlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtxlab.bootcamp.bcproductdata.infra.Scheme;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

  @Scheduled(fixedRate = 600000) // 600000ms = 600s
  public void getBcCpCoingeckoCoinsMK()
      throws InterruptedException, JsonProcessingException {
    HashMap<String, String> uris = new HashMap<>();
    List<TproductCoinListEntity> coinListEntities =
        productDataService.getCoinList();
    List<String> coinCodeStrings = coinListEntities.stream()
        // .filter(e -> e != null)
        .map(e -> e.getCoinCode().trim()).collect(Collectors.toList());
    String coinsIdsCsv = BcUtil.listToCsv(coinCodeStrings);
    uris.put("currency", "usd");
    uris.put("ids", coinsIdsCsv);

    String url = BcUtil.getUrl(Scheme.HTTP, coingeckoDomain, coingeckoPort,
        coingeckoApiVersion + coingeckoCoinMarket, uris);
    System.out.println("url = " + url);
    ApiResponseCoinMKDataDTO apiResponse2 =
        restTemplate.getForObject(url, ApiResponseCoinMKDataDTO.class);

    List<CoinsMKDataDTO> coinsMKDataDTOs = apiResponse2.getData();

    // String apiResponse = restTemplate.getForObject(url, String.class);
    // JsonNode jsonArray = objectMapper.readTree(apiResponse);
    // List<CoinsMKDataDTO> coinsMKDataDTOs = new ArrayList<>();
    // for (JsonNode jsonNode : jsonArray.get("data")) {
    // coinsMKDataDTOs.add(objectMapper.readValue(jsonNode.toString(),CoinsMKDataDTO.class));
    // }
    List<TexCPCoingeckoMKEntity> cryptosEntitiesList =
        DtoMapper.cpCoingeckoMKEntityMap(coinsMKDataDTOs);
    productDataService.saveAllTexCPCoingeckoMKEntites(cryptosEntitiesList);

  }


  @Scheduled(fixedRate = 600000) // ten minutes
  public void getSkFinnhubQuote()
      throws InterruptedException, JsonProcessingException {

    List<TproductStockListEntity> stockListEntities =
        productDataService.getStockList();
    List<String> stockCodeStrings = stockListEntities.stream()
        // .filter(e -> e != null)
        .map(e -> e.getStockCode().trim()).collect(Collectors.toList());
    //String stocksIdsCsv = BcUtil.listToCsv(stockCodeStrings);

    String url;
    HashMap<String, String> uris = new HashMap<>();
    List<TexSkFinnhubQuoteEntity> stockQuotesEntitiesList = new ArrayList<>();
    for (String code : stockCodeStrings) {
      uris.put("symbol", code);

      url = BcUtil.getUrl(Scheme.HTTP, finnhubDomain, finnhubPort,
          finnhubapiVersion + finnhubQuote, uris);
      // System.out.println("url " +url);
  
      ApiResponseStockQuoteDTO apiResponse =
          restTemplate.getForObject(url, ApiResponseStockQuoteDTO.class);
  
      List<StockQuoteDTO> stocksMKDataDTOs = apiResponse.getData();
  
      // System.out.println(stockQuotesEntitiesList2);
  
      // String apiResponse = restTemplate.getForObject(url, String.class);
      // JsonNode jsonArray = objectMapper.readTree(apiResponse);
      // List<StockQuoteDTO> stocksMKDataDTOs = new ArrayList<>();
      // for (JsonNode jsonNode : jsonArray.get("data")) {
      // stocksMKDataDTOs.add(objectMapper.readValue(jsonNode.toString(),StockQuoteDTO.class));
      // }
      stockQuotesEntitiesList.addAll(DtoMapper
          .texSkFinnhubQuoteEntityMap(stocksMKDataDTOs, code));
    }

    productDataService
        .saveAllTexSkFinnhubQuoteEntities(stockQuotesEntitiesList);
  }

  @Scheduled(fixedRate = 600000) // // ten minutes
  public void getSkFinnhubProfile2()
      throws InterruptedException, JsonProcessingException {
    
    List<TproductStockListEntity> stockListEntities =
        productDataService.getStockList();
    List<String> stockCodeStrings = stockListEntities.stream()
        // .filter(e -> e != null)
        .map(e -> e.getStockCode().trim()).collect(Collectors.toList());
    //String stocksIdsCsv = BcUtil.listToCsv(stockCodeStrings);
    String url;
    HashMap<String, String> uris = new HashMap<>();
    List<TexSKFinnhubProfile2Entity> stockProfile2sEntitiesList = new ArrayList<>();
    for (String code : stockCodeStrings) {
      uris = new HashMap<>();
      uris.put("symbol", code);
      url = BcUtil.getUrl(Scheme.HTTP, finnhubDomain, finnhubPort,
        finnhubapiVersion + finnhubProfile2, uris);

        ApiResponseStockProfile2DTO apiResponse =
        restTemplate.getForObject(url, ApiResponseStockProfile2DTO.class);
          //log.info("profile url :" + url);
            List<StockProfile2DTO> stocksProfile2DTOs = apiResponse.getData();
           // log.info("stocksProfile2DTOs data :" + stocksProfile2DTOs);
        
            // String apiResponse = restTemplate.getForObject(url, String.class);
            // JsonNode jsonArray = objectMapper.readTree(apiResponse);
            // List<StockProfile2DTO> stocksProfile2DTOs = new ArrayList<>();
            // for (JsonNode jsonNode : jsonArray.get("data")) {
            // stocksProfile2DTOs.add(objectMapper.readValue(jsonNode.toString(),StockProfile2DTO.class));
            // }

            stockProfile2sEntitiesList.addAll(DtoMapper
                .texSKFinnhubProfile2EntityMap(stocksProfile2DTOs, code));
    }

//        List<StockProfile2DTO> stocksProfile2DTOs = apiResponse2.getData();
    productDataService
        .saveAllTexSKFinnhubProfile2Entities(stockProfile2sEntitiesList);
  }

  @Scheduled(cron = "0 0 0 * * *")
  public void deleteTexternalCryptoCoingeckoMK() {
    productDataService.deleteAllTexCPCoingeckoMKEntites();
  }

  @Scheduled(cron = "0 0 0 * * *")
  public void deleteTexternalStockFinnhubQuote() {
    productDataService.deleteAllTexSkFinnhubQuoteEntities();
  }

  @Scheduled(cron = "0 0 0 * * *")
  public void deleteTexternalStockFinnhubProfile2() {
    productDataService.deleteAllTexSKFinnhubProfile2Entitiess();
  }

  @Scheduled(fixedRate = 60000) // ten minutes
  public void updateTproductCoinsEntity() {
    List<TproductCoinListEntity> coinList = productDataService.getCoinList();

    List<TproductCoinsEntity> tproductCoinsEntities = DtoMapper.tproductCoinsEntityMap(coinList,productDataService);

    productDataService.saveAllTproductCoinsEntities(tproductCoinsEntities);
  }

  @Scheduled(fixedRate = 60000) // ten minutes
  public void updateTproductStocksEntity() {
    List<TproductStockListEntity> stockList = productDataService.getStockList();

    List<TproductStocksEntity> tproductStocksEntities = DtoMapper.tproductStocksEntityMap(stockList, productDataService);

    productDataService.saveAllTproductStocksEntities(tproductStocksEntities);
  }

  @Scheduled(cron = "0 0 6 * * *")
  //@Scheduled(fixedRate = 60000)
  public void updateTproductStocksDailyEntity() {
    System.out.println("updateTproductStocksDailyEntity");
    List<TproductStockListEntity> stockList = productDataService.getStockList();

    List<TproductStocksDailyEntity> tproductStocksDailyEntities = DtoMapper.tproductStocksDailyEntityMap(stockList, productDataService);
    System.out.println("tproductStockDailyEntities");
    System.out.println(tproductStocksDailyEntities);
    System.out.println("tproductStockDailyEntities");
    productDataService.saveAllTproductStocksDailyEntities(tproductStocksDailyEntities);
  }

}
