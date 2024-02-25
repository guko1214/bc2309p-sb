package com.vtxlab.bootcamp.bccryptocoingecko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinsMKData {
  
  private String id;
  private String symbol;
  private String name;
  private String image;
  private double current_price; 
  private double market_cap;
  private int market_cap_rank;
  private double fully_diluted_valuation;
  private double total_volume;
  private double high_24h;
  private double low_24h;
  private double price_change_24h;
  private double price_change_percentage_24h;
  private double market_cap_change_24h;
  private double market_cap_change_percentage_24h;
  private double circulating_supply;
  private double total_supply;
  private double max_supply;
  private double ath;
  private double ath_change_percentage;
  private String ath_date;
  private double atl; 
  private double atl_change_percentage;
  private String atl_date;
  private Roi roi; 
  private String last_updated;

  @Getter
  public static class Roi {
    private double times;
    private String currency;
    private double percentage;
  }



}
