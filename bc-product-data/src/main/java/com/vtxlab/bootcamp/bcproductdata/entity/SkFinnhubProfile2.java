package com.vtxlab.bootcamp.bcproductdata.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "texternal_stock_finnhub_profile2")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SkFinnhubProfile2 {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "quote_date")
  private LocalDateTime quoteDate;
  @Column(name = "quote_stock_code")
  private String quoteStockCode;
  @Column(name = "")
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubindustry;
  private String ipo;
  private String logo;
  private String marketCapitalization;
  private String name;
  private String phone;
  private String shareOutstanding;
  private String ticket;
  private String weburl;

}
