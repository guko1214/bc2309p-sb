package com.vtxlab.bootcamp.bcproductdata.entity;


import java.time.LocalDate;
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
import lombok.ToString;

@Entity
@Table(name = "tproduct_stocks_daily")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class TproductStocksDailyEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "stock_id")
  private Long stockId;
  @Column(name = "trade_date")
  private String tradeDate;
  @Column(name = "day_high")
  private Double dayHigh;
  @Column(name = "day_low")
  private Double dayLow;
  @Column(name = "day_open")
  private Double dayOpen;
  @Column(name = "day_close")
  private Double dayClose;
  @Column(name = "update_time")
  private String updateTime;
}
