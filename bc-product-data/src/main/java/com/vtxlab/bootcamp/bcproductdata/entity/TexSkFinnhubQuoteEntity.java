package com.vtxlab.bootcamp.bcproductdata.entity;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
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
import lombok.ToString;

@Entity
@Table(name = "texternal_stock_finnhub_quote")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class TexSkFinnhubQuoteEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "quote_date")
  private LocalDateTime quoteDate;
  @Column(name = "quote_stock_code")
  private String quoteStockCode;
  @Column(name = "curr_price")
  private Double currPrice;
  @Column(name = "price_chg")
  private Double priceChg;
  @Column(name = "price_chg_pct")
  private Double priceChgPct;
  @Column(name = "price_day_high")
  private Double priceDayHigh;
  @Column(name = "price_day_low")
  private Double priceDayLow;
  @Column(name = "price_open")
  private Double priceOpen;
  @Column(name = "price_prev_close")
  private Double pricePrevClose;

}
