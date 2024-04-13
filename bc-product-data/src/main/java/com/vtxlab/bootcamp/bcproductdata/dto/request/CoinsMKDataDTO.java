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
  private Double currentPrice; 
  private Double marketCap;
  private Integer marketCapRank;
  private Double fullyDilutedValuation;
  private Double totalVolume;
  private Double high24h;
  private Double low24h;
  private Double priceChange24h;
  private Double priceChangePercentage24h;
  private Double marketCapChange24h;
  private Double marketCapChangePercentage24h;
  private Double circulatingSupply;
  private Double totalSupply;
  private Double maxSupply;
  private Double ath;
  private Double athChangePercentage;
  private String athDate;
  private Double atl; 
  private Double atlChangePercentage;
  private String atlDate;
  private Roi roi; 
  private String lastUpdated;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @ToString
  public static class Roi {
    private Double times;
    private String currency;
    private Double percentage;
  }
}

