package com.vtxlab.bootcamp.bcproductdata.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CoinsMKDataDTO {

  private String id;
  private String symbol;
  private String name;
  private String image;
  private double currentPrice; 
  private double marketCap;
  private int marketCapRank;
  private double fullyDilutedValuation;
  private double totalVolume;
  private double high24h;
  private double low24h;
  private double priceChange24h;
  private double priceChangePercentage24h;
  private double marketCapChange24h;
  private double marketCapChangePercentage24h;
  private double circulatingSupply;
  private double totalSupply;
  private double maxSupply;
  private double ath;
  private double athChangePercentage;
  private String athDate;
  private double atl; 
  private double atlChangePercentage;
  private String atlDate;
  private Roi roi; 
  private String lastUpdated;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @ToString
  public static class Roi {
    private double times;
    private String currency;
    private double percentage;
  }
}

